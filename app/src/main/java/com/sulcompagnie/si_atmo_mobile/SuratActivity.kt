package com.sulcompagnie.si_atmo_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sulcompagnie.si_atmo_mobile.CRUD.NotaLunasActivity
import com.sulcompagnie.si_atmo_mobile.CRUD.SuratPerintahKerjaActivity
import kotlinx.android.synthetic.main.activity_surat.*

class SuratActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surat)

        btnSPK.setOnClickListener {
            startActivity(Intent(this, SuratPerintahKerjaActivity::class.java))
        }

        btnNotaLu.setOnClickListener {
            startActivity(Intent(this, NotaLunasActivity::class.java))
        }
    }
}
