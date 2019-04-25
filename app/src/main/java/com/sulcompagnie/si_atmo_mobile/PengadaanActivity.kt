package com.sulcompagnie.si_atmo_mobile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import com.sulcompagnie.si_atmo_mobile.CRUD.TambahPengadaanActivity

import kotlinx.android.synthetic.main.activity_pengadaan.*

class PengadaanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengadaan)
        setSupportActionBar(toolbar)

        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)

        fab.setOnClickListener {
            startActivity(Intent(this@PengadaanActivity, TambahPengadaanActivity::class.java))
        }
    }
}
