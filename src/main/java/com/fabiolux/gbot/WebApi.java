package com.fabiolux.gbot;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebApi {
    @GET("api/v1/public/ticker/btc_brl")
    Call<String> buscaTeste();
}
