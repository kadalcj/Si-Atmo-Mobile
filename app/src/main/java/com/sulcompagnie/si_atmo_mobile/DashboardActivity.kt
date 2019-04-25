package com.sulcompagnie.si_atmo_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
            startActivity(Intent(this@DashboardActivity, SupplierActivity::class.java))
        }

        btnDashPengadaan.setOnClickListener {
            startActivity(Intent(this@DashboardActivity, PengadaanActivity::class.java))
        }

        btnDashLaporan.setOnClickListener {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.btnLogout-> {
                startActivity(Intent(this@DashboardActivity, MainActivity::class.java))
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
