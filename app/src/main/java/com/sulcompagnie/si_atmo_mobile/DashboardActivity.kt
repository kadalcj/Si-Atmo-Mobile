package com.sulcompagnie.si_atmo_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val btnDashSparepart = findViewById<Button>(R.id.btnDashSparepart)
        val btnDashSupplier = findViewById<Button>(R.id.btnDashSupplier)
        val btnDashPengadaan = findViewById<Button>(R.id.btnDashPengadaan)
        val btnDashLaporan = findViewById<Button>(R.id.btnDashLaporan)

        btnDashSparepart.setOnClickListener {
            startActivity(Intent(this@DashboardActivity, SparepartActivity::class.java))
        }

        btnDashSupplier.setOnClickListener {

        }

        btnDashPengadaan.setOnClickListener {

        }

        btnDashLaporan.setOnClickListener {

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
