package com.sulcompagnie.si_atmo_mobile.CRUD

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_web_view_laporan.*

class WebViewLaporanPengeluaranBulananActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_laporan)

        val intent = intent

        val BASEURL = RetrofitClient.BASE_URL
        val tahun = intent.getStringExtra("tahun")

        webView.settings.javaScriptEnabled = true
        webView.loadUrl(BASEURL + "laporan/pengeluaranBulanan/" + tahun)
    }
}