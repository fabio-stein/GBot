package com.fabiolux.gbot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Teste {
    WebApi api = WebController.buildRetrofit().create(WebApi.class);

    @RequestMapping("/teste")
    public String executar() throws IOException {
        String ret = api.buscaTeste().execute().body();
        return ret;
    }
}
