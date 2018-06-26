package com.fabiolux.gbot;

import com.fabiolux.gbot.dao.HibernateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GBotServer {
    public static void main(String[] args) {
        SpringApplication.run(GBotServer.class, args);
        HibernateUtil.start();
    }
}
