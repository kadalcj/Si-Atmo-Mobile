package com.sulcompagnie.si_atmo_mobile

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.Sparepart
import kotlinx.android.synthetic.main.activity_dashboard.*
import retrofit2.Call
import retrofit2.Response

class DashboardActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

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
            startActivity(Intent(this@DashboardActivity, LaporanActivity::class.java))
        }

        btnDashTransaksi.setOnClickListener {
            startActivity(Intent(this@DashboardActivity, HistoryTransaksiActivity::class.java))
        }

        btnDashSurat.setOnClickListener {
            startActivity(Intent(this, SuratActivity::class.java))
        }

        pushNotif()
    }

    private fun pushNotif() {
        RetrofitClient.instance.getPushNotif().enqueue(object : retrofit2.Callback<List<Sparepart>> {
            override fun onFailure(call: Call<List<Sparepart>>, t: Throwable) {
                //Nothing To Do
                Log.d("NOTIFICATION", "Error Boss")
            }

            override fun onResponse(call: Call<List<Sparepart>>, response: Response<List<Sparepart>>) {
                if(response.isSuccessful) {
                    Log.d("NOTIFICATION", "Harusnya Oke")

                    val builder = NotificationCompat.Builder(this@DashboardActivity, "com.sulcompagnie.si_atmo_mobile")
                        .setSmallIcon(R.drawable.notif_logo_24dp)
                        .setContentTitle("SiAtmo Mobile Alert")
                        .setContentText("Beberapa Sparepart yang ada digudang melewati batas stok minimum, silahkan lakukan pengecekan untuk lebih jelasnya.")
                        .setStyle(NotificationCompat.BigTextStyle()
                            .bigText("Beberapa Sparepart yang ada digudang melewati batas stok minimum, silahkan lakukan pengecekan untuk lebih jelasnya."))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                    with(NotificationManagerCompat.from(this@DashboardActivity)) {
                        // notificationId is a unique int for each notification that you must define
                        notify(1122, builder.build())
                    }
                }
                else {
                    Log.d("NOTIFICATION", "Kok Bisa?")
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
