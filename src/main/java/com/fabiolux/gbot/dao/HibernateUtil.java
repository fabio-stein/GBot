package com.fabiolux.gbot.dao;

import com.fabiolux.gbot.dao.models.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static EntityManagerFactory emf;
    public static void start(){
        emf = Persistence.createEntityManagerFactory( "GbotPersistence");
    }

    public static EntityManagerFactory getEmf(){
        return emf;
    }
}
