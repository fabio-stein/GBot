package com.fabiolux.gbot.controller;

import com.fabiolux.gbot.api.BraziliexController;
import com.fabiolux.gbot.api.enums.Market;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
        return "br ok";
    }
}
