package com.fabiolux.gbot.api.apiModels.braziliex;

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
}
