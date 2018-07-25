package com.fabiolux.gbot.api.interfaces;

import com.fabiolux.gbot.api.WebController;
import com.fabiolux.gbot.api.util.ClientUtils;
import com.google.gson.Gson;

public abstract class AbstractClientAPI<T extends Exchange, API> {
    private final Exchange exchange;
    private final API client;
    private final Gson gson;
    public AbstractClientAPI(){
        this.exchange = instantiateExchange();
        this.client = WebController.buildRetrofit(exchange.getBaseUrl()).create(getApiClass());
        this.gson = ClientUtils.getGson();
    }

    public abstract T instantiateExchange();

    public abstract Class<API> getApiClass();

    public Exchange getExchange() {
        return exchange;
    }

    public API getClient() {
        return client;
    }

    public Gson getGson() {
        return gson;
    }
}
