package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_pengeluaran_bulanan.*

class PengeluaranBulananActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengeluaran_bulanan)

        btnLaporan.setOnClickListener {
            val tahun = editTahun.text.toString().trim()
            if(tahun.isEmpty()) {
                editTahun.error = "Kode Sparepart Tidak Boleh Kosong"
                return@setOnClickListener
            }
            else {
                val intent = Intent(this@PengeluaranBulananActivity, WebViewLaporanPengeluaranBulananActivity::class.java)

                intent.putExtra("tahun", tahun)
                startActivity(intent)
            }
        }
    }
}
