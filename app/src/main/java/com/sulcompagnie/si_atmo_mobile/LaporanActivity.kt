package com.sulcompagnie.si_atmo_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sulcompagnie.si_atmo_mobile.CRUD.PendapatanBulananActivity
import com.sulcompagnie.si_atmo_mobile.CRUD.PendapatanTahunanCabangActivity
import com.sulcompagnie.si_atmo_mobile.CRUD.PengeluaranBulananActivity
import com.sulcompagnie.si_atmo_mobile.CRUD.WebViewLaporanStokTerlarisActivity
import kotlinx.android.synthetic.main.activity_laporan.*

class LaporanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan)

        btnPendapatanBulanan.setOnClickListener {
            startActivity(Intent(this@LaporanActivity, PendapatanBulananActivity::class.java))
        }

        btnPendapatanTahunan.setOnClickListener {
            startActivity(Intent(this@LaporanActivity, PendapatanTahunanCabangActivity::class.java))

        }

        btnPengeluaranBulanan.setOnClickListener {
            startActivity(Intent(this@LaporanActivity, PengeluaranBulananActivity::class.java))

        }

        btnStokTerlaris.setOnClickListener {
            startActivity(Intent(this@LaporanActivity, WebViewLaporanStokTerlarisActivity::class.java))

        }

        btnJumlahService.setOnClickListener {
//            startActivity(Intent(this@LaporanActivity, ))

        }

        btnSisaStok.setOnClickListener {
//            startActivity(Intent(this@LaporanActivity, ))
        }
    }
}
