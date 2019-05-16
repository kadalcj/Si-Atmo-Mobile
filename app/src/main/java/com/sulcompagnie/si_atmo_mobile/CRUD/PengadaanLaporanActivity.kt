package com.sulcompagnie.si_atmo_mobile.CRUD

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_pengadaan_laporan.*

class PengadaanLaporanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengadaan_laporan)

        val intent = intent

        val BASEURL = RetrofitClient.BASE_URL
        val noPemesanan = intent.getStringExtra("noPemesanan")

        webview.loadUrl(BASEURL + "pemesanan/printPreview/" + noPemesanan)
    }
}
