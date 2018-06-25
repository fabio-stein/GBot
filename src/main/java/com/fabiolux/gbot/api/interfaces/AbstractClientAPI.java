package com.fabiolux.gbot.api.interfaces;

public abstract class AbstractClientAPI<T extends Exchange> {
    private final Exchange exchange;

    public AbstractClientAPI(T exchange){
        this.exchange = exchange;
    }

    public AbstractClientAPI(){
        this.exchange = instantiateExchange();
    }

    public abstract T instantiateExchange();

    public Exchange getExchange() {
        return exchange;
    }
}
