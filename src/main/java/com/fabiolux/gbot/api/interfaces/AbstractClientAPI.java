package com.fabiolux.gbot.api.interfaces;

import com.fabiolux.gbot.api.enums.TRADING_PLATFORM;

public abstract class AbstractClientAPI<Exchange> {
    public abstract String getHost();
    public abstract TRADING_PLATFORM getTradingPlatform();
    public abstract Exchange teste();
}
