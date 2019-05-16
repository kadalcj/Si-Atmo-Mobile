package com.sulcompagnie.si_atmo_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sulcompagnie.si_atmo_mobile.CRUD.PendapatanBulananActivity
import com.sulcompagnie.si_atmo_mobile.CRUD.PendapatanTahunanCabangActivity
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
//            startActivity(Intent(this@LaporanActivity, ))

        }

        btnStokTerlaris.setOnClickListener {
//            startActivity(Intent(this@LaporanActivity, ))

        }

        btnJumlahService.setOnClickListener {
//            startActivity(Intent(this@LaporanActivity, ))

        }

        btnSisaStok.setOnClickListener {
//            startActivity(Intent(this@LaporanActivity, ))
        }
    }
}
