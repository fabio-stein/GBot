package com.fabiolux.gbot.dao.controller;

import com.fabiolux.gbot.api.interfaces.Exchange;
import com.fabiolux.gbot.dao.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class DaoController<T extends Exchange> {
    protected EntityManager em;
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

    public void persistEntity(Object entity){
        getEm().persist(entity);
    }

    public void mergeEntity(Object entity){
        getEm().merge(entity);
    }

    public <T>T singleOrNull(TypedQuery<T> query) {
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
