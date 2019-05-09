package com.sulcompagnie.si_atmo_mobile.Api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
//    Kos
//    private  const val BASE_URL = "http://192.168.1.3:8000/api/"

//    Kampus
//    private  const val BASE_URL = "http://10.53.4.20:8000/api/"
    private  const val BASE_URL = "http://10.53.7.16:8000/api/"

//    Tidak Ceto
//    private  const val BASE_URL = "http://192.168.100.147:8000/api/"

    val instance: ApiClient by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()

        retrofit.create(ApiClient::class.java)
    }
}