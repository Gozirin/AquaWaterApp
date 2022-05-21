package com.decagon.aqua.core.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun getRetroClientInstance(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("https://aquawaterapp.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}
