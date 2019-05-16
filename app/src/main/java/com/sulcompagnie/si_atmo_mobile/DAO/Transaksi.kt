package com.sulcompagnie.si_atmo_mobile.DAO

data class Transaksi(
    val kodeNota: String,
    val tanggalTransaksi: String,
    val tanggalLunas: String,
    val subtotal: String,
    val diskon: String,
    val total: String,
    val statusTransaksi: String,
    val namaKonsumen: String,
    val platNomorKendaraan: String,
    val noTelpKonsumen: String,
    val alamatKonsumen: String
)