package com.fabiolux.gbot.controller;

import com.fabiolux.gbot.api.BraziliexController;
import com.fabiolux.gbot.dao.HibernateUtil;
import com.fabiolux.gbot.dao.models.Configuration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Teste {

    @RequestMapping("/teste")
    public String executar() throws Exception {
        String ret = "";
        BraziliexController controller = new BraziliexController();
        ret = controller.getExchange().getName();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String conf = HibernateUtil.getEmf().createEntityManager().createQuery("SELECT c FROM Configuration c", Configuration.class).getSingleResult().getConfKey();
        ret = conf;
        return ret;
    }
}
