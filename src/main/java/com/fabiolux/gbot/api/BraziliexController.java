package com.fabiolux.gbot.api;

import com.fabiolux.gbot.api.enums.TRADING_PLATFORM;
import com.fabiolux.gbot.api.exchanges.Braziliex;
import com.fabiolux.gbot.api.interfaces.AbstractClientAPI;

public class BraziliexController extends AbstractClientAPI<Braziliex> {
    @Override
    public String getHost() {
        return null;
    }

    @Override
    public TRADING_PLATFORM getTradingPlatform() {
        return null;
    }

    @Override
    public Braziliex teste() {

        return null;
    }
}