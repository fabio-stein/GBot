package com.fabiolux.gbot.dao.controller;

import com.fabiolux.gbot.api.interfaces.Exchange;
import com.fabiolux.gbot.dao.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DaoController<T extends Exchange> {
    private EntityManager em;
    private EntityTransaction transaction;

    public DaoController(){
        this.em = HibernateUtil.getEmf().createEntityManager();
    }
    public DaoController(EntityManager em){
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }

    public void beginTransaction(){
        transaction = em.getTransaction();
        transaction.begin();
    }

    public void endTransaction(boolean save){
        if(save)
            transaction.commit();
        else
            transaction.rollback();
    }
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
