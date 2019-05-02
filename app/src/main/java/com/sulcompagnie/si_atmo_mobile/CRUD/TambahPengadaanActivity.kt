package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.Pengadaan
import com.sulcompagnie.si_atmo_mobile.DAO.Supplier
import com.sulcompagnie.si_atmo_mobile.PengadaanActivity
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_tambah_pengadaan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.cert.CertPathBuilderSpi

class TambahPengadaanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_pengadaan)

//        val spinnerNama = findViewById<Spinner>(R.id.spinnerNamaPerusahaan)

//        spinnerNama.adapter = ArrayAdapter<String>(this@TambahPengadaanActivity, android.R.layout.simple_spinner_dropdown_item, )

        val spinnerSatuan = findViewById<Spinner>(R.id.spinnerSatuan)
        val status = arrayOf("Buah", "Dus")

        spinnerSatuan.adapter = ArrayAdapter<String>(this@TambahPengadaanActivity, android.R.layout.simple_spinner_dropdown_item, status)

        val btnTambah = findViewById<Button>(R.id.btnTambah)

        btnTambah.setOnClickListener {
            val editNamaPerusahaan = editNamaPerusahaan.text.toString().trim()
            val editJumlahPemesanan = editJumlahPemesanan.text.toString().trim()
            val editSatuan = spinnerSatuan.selectedItem.toString().trim()
            val editKodeSparepart = editKode.text.toString().trim()

            storePengadaan(editNamaPerusahaan, editJumlahPemesanan, editSatuan, editKodeSparepart)
        }

//        getSpinner()
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

    private fun getSpinner() {
        RetrofitClient.instance.getSupplierName().enqueue(object : Callback<List<Supplier>> {
            override fun onFailure(call: Call<List<Supplier>>, t: Throwable) {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Supplier>>, response: Response<List<Supplier>>) {
                val namaPerusahaan = response.body()

                namaPerusahaan?.let {
//                    Log.d("TAG", it.toString())
                }
            }
        })
    }
}
