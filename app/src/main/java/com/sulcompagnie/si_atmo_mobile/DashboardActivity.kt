package com.sulcompagnie.si_atmo_mobile

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentProvider
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.Sparepart
import retrofit2.Call
import retrofit2.Response

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

        pushNotif()
    }

    private fun pushNotif() {
        RetrofitClient.instance.getPushNotif().enqueue(object : retrofit2.Callback<List<Sparepart>> {
            override fun onFailure(call: Call<List<Sparepart>>, t: Throwable) {
                //Nothing To Do
            }

            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(call: Call<List<Sparepart>>, response: Response<List<Sparepart>>) {
                if(response.isSuccessful) {
                    var builder = NotificationCompat.Builder(this@DashboardActivity, "com.sulcompagnie.si_atmo_mobile")
                        .setSmallIcon(R.drawable.notif_logo_24dp)
                        .setContentTitle("SiAmo Alert")
                        .setContentText("Beberapa Sparepart yang ada digudang melewati batas stok minimum, silahkan lakukan pengecekan untuk lebih jelasnya.")
                        .setStyle(NotificationCompat.BigTextStyle()
                            .bigText("Beberapa Sparepart yang ada digudang melewati batas stok minimum, silahkan lakukan pengecekan untuk lebih jelasnya."))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                    with(NotificationManagerCompat.from(this@DashboardActivity)) {
                        // notificationId is a unique int for each notification that you must define
                        notify(101, builder.build())
                    }

                }
            }
        })
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
