package com.fabiolux.gbot.dao.controller;

import com.fabiolux.gbot.api.enums.Market;
import com.fabiolux.gbot.api.exchanges.Braziliex;
import com.fabiolux.gbot.dao.models.BraziliexTradeHistory;

import javax.persistence.TypedQuery;
import java.util.List;

public class BraziliexDaoController extends DaoController<Braziliex> {

    public BraziliexTradeHistory getLatestByTime(Market market){
        TypedQuery<BraziliexTradeHistory> query = getEm().createQuery("SELECT bth FROM BraziliexTradeHistory bth WHERE bth.bthMarket = :market ORDER BY bth.bthTimestamp DESC", BraziliexTradeHistory.class);
        query.setParameter("market", market.getCode());
        query.setMaxResults(1);
        return singleOrNull(query);
    }

    public void persistBraziliexTradeHistory(List<BraziliexTradeHistory> history){
        for(BraziliexTradeHistory h:history)
            getEm().persist(h);
    }

    public <T>T singleOrNull(TypedQuery<T> query){
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
