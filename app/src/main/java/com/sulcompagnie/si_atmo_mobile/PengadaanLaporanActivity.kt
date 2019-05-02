package com.sulcompagnie.si_atmo_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pengadaan_laporan.*

class PengadaanLaporanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengadaan_laporan)

        val intent = intent

        val noPemesanan = intent.getStringExtra("noPemesanan")

//        webview.loadUrl("https://10.53.4.20:8000/api/pemesanan/downloadPDF/" + noPemesanan + ".pdf")
        webview.loadUrl("https://10.53.4.20:8000/api/pemesanan/downloadPDF/" + noPemesanan)
    }
}
