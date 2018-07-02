package com.fabiolux.gbot.api.apiModels.braziliex;

import java.util.ArrayList;
import java.util.List;

public class Orderbook
{
    private Asks[] asks;

    private Bids[] bids;

    public Asks[] getAsks ()
    {
        return asks;
    }

    public void setAsks (Asks[] asks)
    {
        this.asks = asks;
    }

    public Bids[] getBids ()
    {
        return bids;
    }

    public void setBids (Bids[] bids)
    {
        this.bids = bids;
    }

    public List<Order> toOrders(){
        List<Order> orders = new ArrayList<>();
        for(Asks ask:asks)
            orders.add(new Order(ask));
        for(Bids bid:bids)
            orders.add(new Order(bid));
        return orders;
    }
}
