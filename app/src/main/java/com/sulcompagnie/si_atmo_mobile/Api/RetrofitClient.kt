package com.sulcompagnie.si_atmo_mobile.Api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
//    const val BASE_URL = "http://192.168.1.2:8000/api/"
    const val BASE_URL = "http://10.53.7.180:8000/api/"

    val instance: ApiClient by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()

        retrofit.create(ApiClient::class.java)
    }
}