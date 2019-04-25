package com.sulcompagnie.si_atmo_mobile.Api

import com.sulcompagnie.si_atmo_mobile.DAO.Pengadaan
import com.sulcompagnie.si_atmo_mobile.DAO.Sparepart
import com.sulcompagnie.si_atmo_mobile.DAO.Supplier
import com.sulcompagnie.si_atmo_mobile.DAO.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

const val BASE_URL = "http://192.168.1.2:8000/api/"

interface ApiClient {
    //LOGIN
    @FormUrlEncoded
    @POST("login")
    fun loginApps(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<User>

    ////////////////////////////////////////////////////////////////////////////

    //SPAREPART
    //All
    @GET("sparepart")
    fun getSparepart(): Call<List<Sparepart>>

    //Sorting
    @GET("sparepart/bystok")
    fun getSparepartByStok(): Call<List<Sparepart>>

    @GET("sparepart/byharga")
    fun getSparepartByHarga(): Call<List<Sparepart>>

    //Tambah
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

    //Search
    @FormUrlEncoded
    @POST("sparepart/search")
    fun searchSparepart(
        @Field("namaSparepart") namaSparepart: String
    ): Call<List<Sparepart>>

    //Update
    @FormUrlEncoded
    @PATCH("sparepart/{kodeSparepart}")
    fun editSparepart(
        @Path("kodeSparepart") kodeSparepart: String,
        @Field("namaSparepart") namaSparepart: String,
        @Field("tipeSparepart") tipeSparepart: String,
        @Field("merkSparepart") merkSparepart: String,
        @Field("hargaBeli") hargaBeli: String,
        @Field("hargaJual") hargaJual: String
    ): Call<Sparepart>

    //Delete
    @DELETE("sparepart/{kodeSparepart}")
    fun deleteSparepart(
        @Path("kodeSparepart") kodeSparepart: String
    ): Call<Sparepart>

    ////////////////////////////////////////////////////////////////////////////

    //SUPPLIER
    //All
    @GET("supplier")
    fun getSupplier(): Call<List<Supplier>>

    //Tambah
    @FormUrlEncoded
    @POST("supplier")
    fun storeSupplier(
        @Field("namaPerusahaan") namaPerusahaan: String,
        @Field("alamatSupplier") alamatSupplier: String,
        @Field("namaSales") namaSales: String,
        @Field("noTelpSales") noTelpSales: String
    ):Call<Supplier>

    //Search
    @FormUrlEncoded
    @POST("supplier/search")
    fun searchSupplier(
        @Field("namaPerusahaan") namaPerusahaan: String
    ): Call<List<Supplier>>

    //Update
    @FormUrlEncoded
    @PATCH("supplier/{namaPerusahaan}")
    fun editSupplier(
        @Path("namaPerusahaan") namaPerusahaan: String,
        @Field("alamatSupplier") alamatSupplier: String,
        @Field("namaSales") namaSales: String,
        @Field("noTelpSales") noTelpSales: String
    ): Call<Supplier>

    //Delete
    @DELETE("supplier/{namaPerusahaan}")
    fun deleteSupplier(
        @Path("namaPerusahaan") namaPerusahaan: String
    ): Call<Supplier>

    ////////////////////////////////////////////////////////////////////////////
    //All
    @GET("pemesanan")
    fun getPengadaan(): Call<List<Pengadaan>>
}