package org.vosystems.cashback.Data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.Observable

interface ProductApiClient {

    @GET("products")
    fun getProducts(): Call<List<Product>>

    companion object {
        fun create(): ProductApiClient {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://cashbacktest.s3.eu-west-2.amazonaws.com/product_offers.json")
                .build()

            return retrofit.create(ProductApiClient::class.java)
        }
    }
}