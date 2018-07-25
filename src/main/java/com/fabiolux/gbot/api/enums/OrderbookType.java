package com.fabiolux.gbot.api.enums;

public class OrderbookType {
    public static final OrderbookType ASK = new OrderbookType("ask");
    public static final OrderbookType BID = new OrderbookType("bid");

    private final String code;
    public OrderbookType(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static OrderbookType fromString(String type){
        if(type.equals("ask")){
            return ASK;
        }else if(type.equals("bid")){
            return BID;
        }
        return null;
    }
}
