package com.sulcompagnie.si_atmo_mobile.Api

import com.sulcompagnie.si_atmo_mobile.DAO.Sparepart
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

const val BASE_URL = "http://192.168.1.2:8000/api/"

interface ApiClient {
    @GET("sparepart")
    fun getSparepart(): Call<List<Sparepart>>

//    @GET("supplier")
//    fun getSupplier(): Call<List<Supplier>>

    @FormUrlEncoded
    @POST("sparepart")
    fun storeSparepart(
        @Field("kodeSparepart") kodeSparepart: String,
        @Field("namaSparepart") namaSparepart: String,
        @Field("tipeSparepart") tipeSparepart: String,
        @Field("merkSparepart") merkSparepart: String,
        @Field("hargaBeli") hargaBeli: String,
        @Field("hargaJual") hargaJual: String,
        @Field("tempatPeletakan") tempatPeletakan: String,
        @Field("jumlahStok") jumlahStok: String
    ): Call<Sparepart>

//    @FormUrlEncoded
//    @POST("supplier")
//    fun storeSupplier(
//        @Field("namaPerusahaan") kodeSparepart: String,
//        @Field("alamatSupplier") namaSparepart: String,
//        @Field("namaSales") tipeSparepart: String,
//        @Field("noTelpSales") merkSparepart: String
//    ): Call<Supplier>

    @FormUrlEncoded
    @POST("sparepart/search")
    fun searchSparepart(
        @Field("namaSparepart") namaSparepart: String
    ): Call<List<Sparepart>>

    @DELETE("sparepart/{kodeSparepart}")
    fun deleteSparepart(
        @Path("kodeSparepart") kodeSparepart: String
    ): Call<Sparepart>

    companion object {
        operator fun invoke() : ApiClient {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}