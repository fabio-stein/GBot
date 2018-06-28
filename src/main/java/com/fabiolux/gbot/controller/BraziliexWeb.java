package com.fabiolux.gbot.controller;

import com.fabiolux.gbot.api.BraziliexController;
import com.fabiolux.gbot.api.apiModels.braziliex.Orderbook;
import com.fabiolux.gbot.api.enums.Market;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController
public class BraziliexWeb {
    @RequestMapping("braziliex/update")
    public String update() throws IOException {
        BraziliexController controller = new BraziliexController();
        controller.updateTradeHistory(Market.BTC_BRL);
        for(Market m:Market.getAllMarkets()) {
            System.out.println("Updating Market History: " + m.getCode());
            controller.updateTradeHistory(m);
        }
        return "Updated";
    }

    @RequestMapping("braziliex/orderbook")
    public String orederBook() throws IOException {
        BraziliexController controller = new BraziliexController();
        Orderbook tick = controller.getClient().getOrderBook(Market.XMR_BRL.getCode()).execute().body();
        return controller.getGson().toJson(tick);
    }
    int asks = 0;
    int bids = 0;

    @Scheduled(fixedRate = 500)
    public void teste() throws IOException {
        compareTime(COMPARE_ACTION.START);
        BraziliexController controller = new BraziliexController();
        Orderbook tick = controller.getClient().getOrderBook(Market.BTC_BRL.getCode()).execute().body();
        int asksDiff = tick.getAsks().length-asks;
        asks = tick.getAsks().length;
        int bidsDiff = tick.getBids().length-bids;
        bids = tick.getBids().length;
        //compareTime(COMPARE_ACTION.STOP);
        String update = "UPDATE - ASKS: "+asksDiff+" BIDS: "+bidsDiff;
        if(asksDiff!=0 || bidsDiff!=0)
            System.out.println(update);
    }

    LocalDateTime begin;
    LocalDateTime end;
    public void compareTime(COMPARE_ACTION action){
        if(action==COMPARE_ACTION.START)
            begin = LocalDateTime.now();
        else{
            end = LocalDateTime.now();
            System.out.println("EXECUTION TIME: "+begin.until(end,ChronoUnit.MILLIS)+"ms");
        }
    }

    public enum COMPARE_ACTION{
        START,
        STOP
    }
}
