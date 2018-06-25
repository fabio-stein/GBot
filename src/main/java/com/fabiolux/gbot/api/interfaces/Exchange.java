package com.fabiolux.gbot.api.interfaces;

import com.fabiolux.gbot.api.enums.TRADING_EXCHANGE;

public interface Exchange {
    String getName();
    TRADING_EXCHANGE getTradingExchange();
}
