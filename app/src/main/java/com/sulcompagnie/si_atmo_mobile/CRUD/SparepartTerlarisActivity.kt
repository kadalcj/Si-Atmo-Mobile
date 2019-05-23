package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_sparepart_terlaris.*

class SparepartTerlarisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sparepart_terlaris)

        btnLaporan.setOnClickListener {
            val intent = Intent(this@SparepartTerlarisActivity, WebViewLaporanSparepartTerlarisActivity::class.java)
            val tahun =  editTahun.text.toString()

            intent.putExtra("tahun", tahun)
            startActivity(intent)
        }
    }
}
