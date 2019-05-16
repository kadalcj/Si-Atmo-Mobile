package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_pendapatan_bulanan.*

class PendapatanBulananActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pendapatan_bulanan)

        btnLaporan.setOnClickListener {
            val tahun = editTahun.text.toString().trim()
            val intent = Intent(this@PendapatanBulananActivity, WebViewLaporanPendapatanBulananActivity::class.java)

            intent.putExtra("tahun", tahun)
            startActivity(intent)
        }
    }
}
