package com.fabiolux.gbot;

import com.fabiolux.gbot.dao.HibernateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GBotServer {
    public static void main(String[] args) {
        SpringApplication.run(GBotServer.class, args);
        HibernateUtil.start();
    }
}
