package com.fabiolux.gbot.api;

import com.fabiolux.gbot.api.enums.TRADING_EXCHANGE;
import com.fabiolux.gbot.api.exchanges.Braziliex;
import com.fabiolux.gbot.api.interfaces.AbstractClientAPI;
import com.fabiolux.gbot.api.interfaces.BrazilliexApi;

import java.io.IOException;

public class BraziliexController extends AbstractClientAPI<Braziliex, BrazilliexApi> {


    @Override
    public Braziliex instantiateExchange() {
        return new Braziliex();
    }

    @Override
    public Class<BrazilliexApi> getApiClass() {
        return BrazilliexApi.class;
    }

    @Override
    public String getBtcJson() throws IOException {
        return getClient().buscaTeste().execute().body();
    }
}