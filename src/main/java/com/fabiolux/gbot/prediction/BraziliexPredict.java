package com.fabiolux.gbot.prediction;

import com.fabiolux.gbot.api.BraziliexController;
import com.fabiolux.gbot.api.enums.Market;
import com.fabiolux.gbot.dao.models.BraziliexPricePrediction;
import com.fabiolux.gbot.dao.models.BraziliexTradeHistory;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@RestController
public class BraziliexPredict {
    BraziliexController controller;

    @PostConstruct
    public void init(){
        //Simple wait for db connection and start
        Observable.create(emitter -> {
            Thread.sleep(5000);
            controller = new BraziliexController();
            executePredict();
        })
                .subscribeOn(Schedulers.newThread())
                .subscribe();
    }

    public void executePredict(){
        Observable.create(emitter -> {
            try {
                //controller.updateTradeHistory(Market.BTC_BRL);
                BraziliexPricePrediction bpp = new BraziliexPricePrediction();
                bpp.setBppMarket(Market.BTC_BRL.getCode());
                bpp.setBppPredictionCreatedTimestamp(Timestamp.from(Instant.now()));
                bpp.setBppPredictionForTimestamp(Timestamp.from(Instant.now().plus(1, ChronoUnit.SECONDS)));
                //Simulate prediction with the same of last price
                BraziliexTradeHistory history = controller.getDao().getLatestByTime(Market.BTC_BRL);
                BigDecimal predictedPrice = history.getBthPrice();
                BigDecimal randomSum = new BigDecimal(getRandomNumberInRange(-5,+5));
                predictedPrice = predictedPrice.add(randomSum);

                bpp.setBppPredictionPrice(predictedPrice);
                controller.getDao().beginTransaction();
                controller.getDao().persistEntity(bpp);
                controller.getDao().endTransaction(true);
                System.out.println("PREDICTED VALUE: "+bpp.getBppPredictionPrice());
                Thread.sleep(30000);
            }catch (Exception e){
                System.out.println("ERROR PREDICTING");
            }
            executePredict();
        })
                .subscribeOn(Schedulers.newThread())
                .subscribe();
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
