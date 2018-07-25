package com.fabiolux.gbot.api.enums;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static final Market BTC_BRL = new Market("btc_brl");
    public static final Market BCH_BRL = new Market("bch_brl");
    public static final Market USDT_BRL = new Market("usdt_brl");
    public static final Market ETH_BRL = new Market("eth_brl");
    public static final Market LTC_BRL = new Market("ltc_brl");
    public static final Market XMR_BRL = new Market("xmr_brl");

    private final String code;
    private Market(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public boolean equals(Market market){
        return market.getCode().equals(this.code);
    }

    private static final List<Market> allMarkets = new ArrayList<Market>(){
        {
            add(BTC_BRL);
            add(BCH_BRL);
            add(USDT_BRL);
            add(ETH_BRL);
            add(LTC_BRL);
            add(XMR_BRL);
        }
    };

    public Market fromString(String market){
        for(Market m:allMarkets){
            if(market.equals(m.getCode()))
                return m;
        }
        return null;
    }

    public static List<Market> getAllMarkets(){
        return allMarkets;
    }
}
