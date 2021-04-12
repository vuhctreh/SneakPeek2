package com.victor.sneakpeek2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * The interface Stock x api.
 */
public interface StockXApi {
    /**
     * Gets product info.
     * For Retrofit.
     *
     * @param url the url
     * @return the product info
     */
    @GET
    Call<ProductInfo> getProductInfo(@Url String url);
}
