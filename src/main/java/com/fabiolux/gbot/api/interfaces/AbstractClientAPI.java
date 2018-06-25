package com.fabiolux.gbot.api.interfaces;

import com.fabiolux.gbot.api.WebController;
import retrofit2.Retrofit;

import java.io.IOException;

public abstract class AbstractClientAPI<T extends Exchange, API> {
    private final Exchange exchange;
    private API client;
    public AbstractClientAPI(){
        this.exchange = instantiateExchange();
        this.client = WebController.buildRetrofit(exchange.getBaseUrl()).create(getApiClass());
    }

    public abstract T instantiateExchange();

    public abstract Class<API> getApiClass();

    public Exchange getExchange() {
        return exchange;
    }

    public abstract String getBtcJson() throws IOException;

    public API getClient() {
        return client;
    }

    public void setClient(API client) {
        this.client = client;
    }
}
