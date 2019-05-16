package com.sulcompagnie.si_atmo_mobile.Api

import com.sulcompagnie.si_atmo_mobile.DAO.*
import retrofit2.Call
import retrofit2.http.*

interface ApiClient {
    //LOGIN
    @FormUrlEncoded
    @POST("login")
    fun loginApps(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<User>

    ////////////////////////////////////////////////////////////////////////////
    //Push Notification
    @GET("sparepart/pushnotif")
    fun getPushNotif(): Call<List<Sparepart>>

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
        @Field("jumlahStok") jumlahStok: Int
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

    //Spinner
    //All
    @GET("supplier/namaperusahaan")
    fun getSupplierName(): Call<List<Supplier>>

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
    //PENGADAAN
    //All
    @GET("pemesanan")
    fun getPengadaan(): Call<List<Pengadaan>>

    @POST("pemesanan/{noPemesanan}")
    fun getDetilPengadaan(
        @Path("noPemesanan") noPemesanan: String
    ): Call<List<Pengadaan>>

    //Store
    @FormUrlEncoded
    @POST("pemesanan")
    fun storePengadaan(
        @Field("namaPerusahaan") namaPerusahaan: String,
        @Field("jumlahPemesanan") jumlahPemesanan: String,
        @Field("satuan") satuan: String,
        @Field("kodeSparepart") kodeSparepart: String
    ): Call<Pengadaan>

    //Add Detil
    @FormUrlEncoded
    @POST("pemesanan/add")
    fun addDetilPengadaan(
        @Field("noPemesanan") noPemesanan: String,
        @Field("jumlahPemesanan") jumlahPemesanan: String,
        @Field("satuan") satuan: String,
        @Field("kodeSparepart") kodeSparepart: String
    ): Call<Pengadaan>

    //Update Status
    @FormUrlEncoded
    @POST("pemesanan/status/{noPemesanan}")
    fun updateStatus(
        @Path("noPemesanan") noPemesanan: String,
        @Field("statusPemesanan") statusPemesanan:String
    ): Call<Pengadaan>

    //Delete
    @DELETE("pemesanan/{noPemesanan}")
    fun deletePemesanan(
        @Path("noPemesanan") noPemesanan: String
    ): Call<Pengadaan>

    ////////////////////////////////////////////////////////////////////////////
    //Transaksi Sparepart
    @FormUrlEncoded
    @POST("historytransaksi")
    fun getHistoryTrans(
        @Field("platNomorKendaraan") platNomorKendaraan: String,
        @Field("noTelpKonsumen") noTelpKonsumen: String
    ): Call<List<Transaksi>>

    @GET("historytransaksi/{kodeNota}")
    fun getDetilTransSparepart(
        @Path("kodeNota") kodeNota: String
    ): Call<List<DetilTransaksiSparepart>>
}