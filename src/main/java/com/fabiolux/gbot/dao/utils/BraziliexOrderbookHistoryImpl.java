package com.fabiolux.gbot.dao.utils;

import com.fabiolux.gbot.api.enums.OrderbookType;
import com.fabiolux.gbot.dao.models.BraziliexOrderbookHistory;

import java.util.ArrayList;
import java.util.List;

public abstract class BraziliexOrderbookHistoryImpl {
    public static List<BraziliexOrderbookHistory> getAsks(List<BraziliexOrderbookHistory> orders){
        return getByType(orders, OrderbookType.ASK);
    }

    public static List<BraziliexOrderbookHistory> getBids(List<BraziliexOrderbookHistory> orders){
        return getByType(orders, OrderbookType.BID);
    }

    public static List<BraziliexOrderbookHistory> getByType(List<BraziliexOrderbookHistory> orders, OrderbookType type){
        List<BraziliexOrderbookHistory> ret = new ArrayList<>();
        for(BraziliexOrderbookHistory order:orders)
            if(order.getBohType().equals(type.getCode()))
                ret.add(order);
        return ret;
    }
}
