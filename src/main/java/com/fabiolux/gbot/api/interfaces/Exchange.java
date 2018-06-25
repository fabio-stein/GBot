package com.fabiolux.gbot.api.interfaces;

import com.fabiolux.gbot.api.enums.TRADING_EXCHANGE;

public interface Exchange {
    String getName();
    String getBaseUrl();
    TRADING_EXCHANGE getTradingExchange();
}
