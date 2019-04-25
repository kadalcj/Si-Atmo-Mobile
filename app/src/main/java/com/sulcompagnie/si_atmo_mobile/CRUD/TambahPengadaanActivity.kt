package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.Pengadaan
import com.sulcompagnie.si_atmo_mobile.PengadaanActivity
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_tambah_pengadaan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahPengadaanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_pengadaan)

        val btnTambah = findViewById<Button>(R.id.btnTambah)

        btnTambah.setOnClickListener {
            val editNamaPerusahaan = editNamaPerusahaan.text.toString().trim()
            val editJumlahPemesanan = editJumlahPemesanan.text.toString().trim()
            val editSatuan = editSatuan.text.toString().trim()
            val editKodeSparepart = editKode.text.toString().trim()

            storePengadaan(editNamaPerusahaan, editJumlahPemesanan, editSatuan, editKodeSparepart)
        }
    }

    private fun storePengadaan(namaPerusahaan: String, jumlahStok: String, satuan: String, kodeSparepart: String) {
        RetrofitClient.instance.storePengadaan(namaPerusahaan, jumlahStok, satuan, kodeSparepart).enqueue(object : Callback<Pengadaan> {
            override fun onFailure(call: Call<Pengadaan>, t: Throwable) {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Pengadaan>, response: Response<Pengadaan>) {
                startActivity(Intent(this@TambahPengadaanActivity, PengadaanActivity::class.java))
                finish()
                Toast.makeText(applicationContext, "Berhasil Tambah Supplier", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
