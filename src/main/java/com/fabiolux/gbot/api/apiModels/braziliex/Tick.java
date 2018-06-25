package com.fabiolux.gbot.api.apiModels.braziliex;

public class Tick {
    private String highestBid;
    private String last;
    private String highestBid24;
    private String quoteVolume;
    private String baseVolume;
    private String baseVolume24;
    private String quoteVolume24;
    private String lowestAsk24;
    private String market;
    private String market_fee_discount;
    private String percentChange;
    private String active;
    private String lowestAsk;

    public String getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(String highestBid) {
        this.highestBid = highestBid;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getHighestBid24() {
        return highestBid24;
    }

    public void setHighestBid24(String highestBid24) {
        this.highestBid24 = highestBid24;
    }

    public String getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(String quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public String getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(String baseVolume) {
        this.baseVolume = baseVolume;
    }

    public String getBaseVolume24() {
        return baseVolume24;
    }

    public void setBaseVolume24(String baseVolume24) {
        this.baseVolume24 = baseVolume24;
    }

    public String getQuoteVolume24() {
        return quoteVolume24;
    }

    public void setQuoteVolume24(String quoteVolume24) {
        this.quoteVolume24 = quoteVolume24;
    }

    public String getLowestAsk24() {
        return lowestAsk24;
    }

    public void setLowestAsk24(String lowestAsk24) {
        this.lowestAsk24 = lowestAsk24;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMarket_fee_discount() {
        return market_fee_discount;
    }

    public void setMarket_fee_discount(String market_fee_discount) {
        this.market_fee_discount = market_fee_discount;
    }

    public String getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(String lowestAsk) {
        this.lowestAsk = lowestAsk;
    }
}
