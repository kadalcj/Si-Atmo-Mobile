package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_web_view_laporan.*

class WebViewLaporanSisaStokActivity : AppCompatActivity() {
    val BASEURL = RetrofitClient.BASE_URL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_laporan)

        val intent = intent

        val tahun = intent.getStringExtra("tahun")
        val sparepart = intent.getStringExtra("tipe")

        webView.settings.javaScriptEnabled = true
        webView.loadUrl(BASEURL + "laporan/sisastok/" + tahun + "/" + sparepart)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cetak, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intent = intent

        val tahun = intent.getStringExtra("tahun")
        val sparepart = intent.getStringExtra("tipe")

        when(item?.itemId) {
            R.id.btnCetak-> {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse(BASEURL + "laporan/sisastok/" + tahun + "/" + sparepart)
                startActivity(openURL)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}