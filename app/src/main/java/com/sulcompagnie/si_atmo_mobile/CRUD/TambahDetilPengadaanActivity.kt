package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.Pengadaan
import com.sulcompagnie.si_atmo_mobile.DAO.Sparepart
import com.sulcompagnie.si_atmo_mobile.PengadaanActivity
import com.sulcompagnie.si_atmo_mobile.R
import com.sulcompagnie.si_atmo_mobile.SparepartActivity
import kotlinx.android.synthetic.main.activity_edit_sparepart.*
import kotlinx.android.synthetic.main.activity_tambah_detil_pengadaan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahDetilPengadaanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_detil_pengadaan)

        val spinnerKode = findViewById<Spinner>(R.id.spinnerKode)

        RetrofitClient.instance.getSpinnerKode().enqueue(object : Callback<List<Sparepart>> {
            override fun onFailure(call: Call<List<Sparepart>>, t: Throwable) {
                //Nothing To Do
            }

            override fun onResponse(call: Call<List<Sparepart>>, response: Response<List<Sparepart>>) {
                val kodeSparepart =  response.body()

                val spinner: ArrayList<String> = ArrayList()

                val size = response.body()?.lastIndex

                for(i in 0..size!!) {
                    spinner.add(kodeSparepart?.get(i)?.kodeSparepart.toString().trim())
                }

                spinnerKode.adapter = ArrayAdapter<String>(this@TambahDetilPengadaanActivity, android.R.layout.simple_spinner_dropdown_item, spinner)
            }
        })

        val intent = intent

        val spinSatuan = findViewById<Spinner>(R.id.spinnerSatuan)
        val satuan = arrayOf("Buah", "Dus")

        spinSatuan.adapter = ArrayAdapter<String>(this@TambahDetilPengadaanActivity, android.R.layout.simple_spinner_dropdown_item, satuan)

        btnTambah.setOnClickListener {
            val noPemesanan = intent.getStringExtra("noPemesanan")
            val kodeSparepart = spinnerKode.selectedItem.toString().trim()
            val jumlahPengadaan = editJumlahPengadaan.text.toString().trim()
            val satuan = spinSatuan.selectedItem.toString().trim()

            if(jumlahPengadaan.isEmpty()) {
                editJumlahPengadaan.error = "Jumlah Pengadaan Tidak Boleh Kosong"
                return@setOnClickListener
            }

            RetrofitClient.instance.addDetilPengadaan(noPemesanan.toString(), jumlahPengadaan, satuan, kodeSparepart).enqueue(object : Callback<Pengadaan> {
                override fun onFailure(call: Call<Pengadaan>, t: Throwable) {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Pengadaan>, response: Response<Pengadaan>) {
                    if(response.isSuccessful) {
                        startActivity(Intent(this@TambahDetilPengadaanActivity, PengadaanActivity::class.java))
                        finish()
                        Toast.makeText(applicationContext, "Berhasil Tambah Item Pengadaan", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(applicationContext, "Gagal Menambah Item", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}
