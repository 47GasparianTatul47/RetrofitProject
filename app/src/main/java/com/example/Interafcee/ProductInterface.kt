package com.example.retrofitproject

import com.example.Models.ProductModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ProductInterfacee {

    @GET("api/users?page=2")
    fun getProductSingle(): Call<ProductModel>

}

object ProductRetrofitService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}