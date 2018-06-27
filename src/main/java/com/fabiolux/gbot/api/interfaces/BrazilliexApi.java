package com.fabiolux.gbot.api.interfaces;

import com.fabiolux.gbot.api.apiModels.braziliex.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface BrazilliexApi {

    /**
     * @return Used to get the open and available trading markets at Braziliex along with other meta data.
     */
    @GET("api/v1/public/currencies")
    Call<Currencies> getCurrencies();

    /**
     * @return Used to get the last 24 hour summary of all active exchanges.
     */
    @GET("api/v1/public/ticker")
    Call<Ticker> getTicker();

    /**
     * @param market required a string literal for the market (ex: ltc_btc)
     * @return Used to get the current tick values for a market.
     */
    @GET("api/v1/public/ticker/{market}")
    Call<Tick> getTick(@Path("market") String market);

    /**
     * @param market required a string literal for the market (ex: ltc_btc)
     * @return Used to get retrieve the orderbook for a given market.
     */
    @GET("api/v1/public/orderbook/{market}")
    Call<Orderbook> getOrderBook(@Path("market") String market);

    /**
     * @param market required a string literal for the market (ex: ltc_btc, eth_btc, dash_btc, eth_brl, btc_brl, eth_brl)
     * @return Used to get retrieve the last 15 trades.
     */
    @GET("api/v1/public/tradehistory/{market}")
    Call<List<TradeHistory>> getTradeHistory(@Path("market") String market);


    @FormUrlEncoded
    @POST("api/v1/private")
    Call<String> getBalance(@Field(value = "nonce") Long nonce, @Field(value = "command") String command, @Header(value = "Key") String key, @Header(value = "Sign") String sign);
}
