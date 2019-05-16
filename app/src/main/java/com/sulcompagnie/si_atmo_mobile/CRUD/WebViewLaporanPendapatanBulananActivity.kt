package com.sulcompagnie.si_atmo_mobile.CRUD

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_web_view_laporan.*

class WebViewLaporanPendapatanBulananActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_laporan)

        val intent = intent

        val BASEURL = RetrofitClient.BASE_URL
        val tahun = intent.getStringExtra("tahun")

        webView.settings.javaScriptEnabled = true
        webView.loadUrl(BASEURL + "laporan/pendapatanBulanan/" + tahun)
    }
}
