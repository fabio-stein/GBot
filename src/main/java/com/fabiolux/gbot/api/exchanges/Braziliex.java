package com.fabiolux.gbot.api.exchanges;

import com.fabiolux.gbot.api.enums.EXCHANGES;
import com.fabiolux.gbot.api.interfaces.Exchange;

public class Braziliex implements Exchange {
    @Override
    public String getName() {
        return "Braziliex";
    }

    @Override
    public String getBaseUrl() {
        return "https://braziliex.com";
    }

    @Override
    public EXCHANGES getTradingExchange() {
        return EXCHANGES.BRAZILIEX;
    }
}
