package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_pendapatan_tahunan_cabang.*

class PendapatanTahunanCabangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pendapatan_tahunan_cabang)

        btnLaporan.setOnClickListener {
            val intent = Intent(this@PendapatanTahunanCabangActivity, WebViewLaporanPendapatanTahunanCabangActivity::class.java)
            val tahun =  editTahun.text.toString()

            intent.putExtra("tahun", tahun)
            startActivity(intent)
        }
    }
}
