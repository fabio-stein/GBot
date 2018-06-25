package com.fabiolux.gbot.api;

import com.fabiolux.gbot.api.enums.TRADING_EXCHANGE;
import com.fabiolux.gbot.api.exchanges.Braziliex;
import com.fabiolux.gbot.api.interfaces.AbstractClientAPI;

public class BraziliexController extends AbstractClientAPI<Braziliex> {
    public BraziliexController(Braziliex exchange) {
        super(exchange);
    }

    @Override
    public Braziliex instantiateExchange() {
        return new Braziliex();
    }
}