package com.fabiolux.gbot.api.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BrazilliexApi {
    @GET("api/v1/public/ticker/btc_brl")
    Call<String> buscaTeste();
}
