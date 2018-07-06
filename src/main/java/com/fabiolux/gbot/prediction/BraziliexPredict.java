package com.fabiolux.gbot.prediction;

import com.fabiolux.gbot.api.BraziliexController;
import com.fabiolux.gbot.api.enums.Market;
import com.fabiolux.gbot.dao.models.BraziliexPricePrediction;
import com.fabiolux.gbot.dao.models.BraziliexTradeHistory;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RestController
public class BraziliexPredict {
    BraziliexController controller;

    @PostConstruct
    public void init(){
        //Simple wait for db connection and start
        Observable.create(emitter -> {
            Thread.sleep(3000);
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
                bpp.setBppPredictionPrice(history.getBthPrice());
                controller.getDao().beginTransaction();
                controller.getDao().persistEntity(bpp);
                controller.getDao().endTransaction(true);
                Thread.sleep(1000);
                System.out.println("PREDICTED VALUE: "+bpp.getBppPredictionPrice());
            }catch (Exception e){
                System.out.println("ERROR PREDICTING");
            }
            executePredict();
        })
                .subscribeOn(Schedulers.newThread())
                .subscribe();
    }
}
