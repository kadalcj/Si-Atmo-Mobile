package com.sulcompagnie.si_atmo_mobile.DAO

data class TransaksiSparepart(
    val kodeNota: String,
    val tanggalTransaksi: String,
    val tanggalLunas: String,
    val subTotal: String,
    val diskon: String,
    val total: String,
    val statusTransaksi: String,
    val namaKonsumen: String,
    val noTelp: String,
    val alamatKonsumen: String
)