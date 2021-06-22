package com.example.retrofitproject

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserInterfacee {

    @GET("api/users/5")
    fun getSingleUser(): Call<UserModel>

}

object UserRetrofitService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}