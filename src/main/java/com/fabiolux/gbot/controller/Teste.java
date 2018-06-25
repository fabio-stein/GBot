package com.fabiolux.gbot.controller;

import com.fabiolux.gbot.api.BraziliexController;
import com.fabiolux.gbot.api.apiModels.braziliex.Currencies;
import com.fabiolux.gbot.api.apiModels.braziliex.Currency;
import com.fabiolux.gbot.api.interfaces.BrazilliexApi;
import com.fabiolux.gbot.api.WebController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class Teste {

    @RequestMapping("/teste")
    public String executar() throws IOException {
        String ret = "";
        BraziliexController controller = new BraziliexController();
        ret = controller.getExchange().getName();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        controller.getClient().getOrderBook("btc_brl").execute().body();
        return ret;
    }
}
