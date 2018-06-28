package com.fabiolux.gbot.api.interfaces;

import com.fabiolux.gbot.api.enums.EXCHANGES;

public interface Exchange {
    String getName();
    String getBaseUrl();
    EXCHANGES getTradingExchange();
}
