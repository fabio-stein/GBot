package com.fabiolux.gbot.api.exchanges;

import com.fabiolux.gbot.api.enums.TRADING_EXCHANGE;
import com.fabiolux.gbot.api.interfaces.Exchange;

public class Braziliex implements Exchange {
    @Override
    public String getName() {
        return "Braziliex";
    }

    @Override
    public TRADING_EXCHANGE getTradingExchange() {
        return TRADING_EXCHANGE.BRAZILIEX;
    }
}
