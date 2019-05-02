package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.Pengadaan
import com.sulcompagnie.si_atmo_mobile.PengadaanActivity
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_detil_pengadaan.*
import kotlinx.android.synthetic.main.activity_update_status_pengadaan.*
import kotlinx.android.synthetic.main.activity_update_status_pengadaan.btnUpdate
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateStatusPengadaanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_status_pengadaan)

        val intent = intent

        val spinner = findViewById<Spinner>(R.id.spinner)
        val kodeSpinner = arrayOf("Shipping", "Arrived")

        spinner.adapter = ArrayAdapter<String>(this@UpdateStatusPengadaanActivity, android.R.layout.simple_spinner_dropdown_item, kodeSpinner)

        val noPemesanan = intent.getStringExtra("noPemesanan")
        val namaPerusahaan = intent.getStringExtra("namaPerusahaan")
        val tanggalPemesanan = intent.getStringExtra("tanggalPemesanan")
        val statusPemesanan = intent.getStringExtra("statusPemesanan")

        val textNoPemesanan = findViewById<TextView>(R.id.editNoPemesanan)
        val textNamaPerusahaan = findViewById<TextView>(R.id.editNamaPerusahaan)
        val textTanggalPemesanan = findViewById<TextView>(R.id.editTanggal)

        textNoPemesanan.text = noPemesanan
        textNamaPerusahaan.text = namaPerusahaan
        textTanggalPemesanan.text = tanggalPemesanan

        btnUpdate.setOnClickListener {
            RetrofitClient.instance.updateStatus(noPemesanan, spinner.selectedItem.toString().trim()).enqueue(object : Callback<Pengadaan> {
                override fun onFailure(call: Call<Pengadaan>, t: Throwable) {

                }

                override fun onResponse(call: Call<Pengadaan>, response: Response<Pengadaan>) {
                    startActivity(Intent(this@UpdateStatusPengadaanActivity, PengadaanActivity::class.java))
                    finish()
                    Toast.makeText(applicationContext, "Berhasil Update Status", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
