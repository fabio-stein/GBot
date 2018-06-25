package com.fabiolux.gbot.controller;

import com.fabiolux.gbot.api.BraziliexController;
import com.fabiolux.gbot.api.interfaces.BrazilliexApi;
import com.fabiolux.gbot.api.WebController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Teste {

    @RequestMapping("/teste")
    public String executar() throws IOException {
        String ret = "";
        BraziliexController controller = new BraziliexController();
        ret = controller.getExchange().getName();
        ret = controller.getBtcJson();
        return ret;
    }
}
