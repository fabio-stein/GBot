package com.fabiolux.gbot.controller;

import com.fabiolux.gbot.api.interfaces.BrazilliexApi;
import com.fabiolux.gbot.api.WebController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Teste {
    BrazilliexApi api = WebController.buildRetrofit().create(BrazilliexApi.class);

    @RequestMapping("/teste")
    public String executar() throws IOException {
        String ret = api.buscaTeste().execute().body();
        return ret;
    }
}
