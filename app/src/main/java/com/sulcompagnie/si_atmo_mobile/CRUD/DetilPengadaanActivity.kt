package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.sulcompagnie.si_atmo_mobile.Adapter.DetilPengadaanAdapter
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.Pengadaan
import com.sulcompagnie.si_atmo_mobile.PengadaanActivity
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_detil_pengadaan.*
import kotlinx.android.synthetic.main.content_pengadaan.*
import kotlinx.android.synthetic.main.content_pengadaan.refreshLayout
import kotlinx.android.synthetic.main.content_supplier.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetilPengadaanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detil_pengadaan)

        //get Intent
        val intent = intent
        //content of Intent
        val noPemesanan = intent.getStringExtra("noPemesanan")
        val namaPerusahaan = intent.getStringExtra("namaPerusahaan")
        val tanggalPemesanan = intent.getStringExtra("tanggalPemesanan")
        val statusPemesanan = intent.getStringExtra("statusPemesanan")

        //Set Text
        val textNamaPerusahaan = findViewById<TextView>(R.id.textNamaPerusahaan)
        val textTanggalPemesanan = findViewById<TextView>(R.id.textTanggalPemesanan)
        val textStatusPemesanan = findViewById<TextView>(R.id.textStatusPemesanan)

        val btnHapus = findViewById<Button>(R.id.btnHapus)

        //Change Text
        textNamaPerusahaan.text = namaPerusahaan
        textTanggalPemesanan.text = tanggalPemesanan
        textStatusPemesanan.text = statusPemesanan

        refreshLayout.setOnRefreshListener {
            fetchDetil(noPemesanan)
        }
        fetchDetil(noPemesanan)

        btnHapus.setOnClickListener {
//            println(noPemesanan)
            batalPesan(noPemesanan)
        }
    }

    private fun fetchDetil(noPemesanan: String) {
        refreshLayout.isRefreshing = true

        RetrofitClient.instance.getDetilPengadaan(noPemesanan).enqueue(object : Callback<List<Pengadaan>> {
            override fun onFailure(call: Call<List<Pengadaan>>, t: Throwable) {
                refreshLayout.isRefreshing = false
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Pengadaan>>, response: Response<List<Pengadaan>>) {
                refreshLayout.isRefreshing = false
                val pengadaan = response.body()

                pengadaan?.let {
                    showDetilPengadaan(it)
                }
            }
        })
    }

    private fun showDetilPengadaan(pengadaan: List<Pengadaan>) {
        recycleViewDetil.layoutManager = LinearLayoutManager(this)
        recycleViewDetil.adapter = DetilPengadaanAdapter(pengadaan)
    }

    private fun batalPesan(noPemesanan: String) {
        RetrofitClient.instance.deletePemesanan(noPemesanan).enqueue(object : Callback<Pengadaan> {
            override fun onFailure(call: Call<Pengadaan>, t: Throwable) {
                Toast.makeText(applicationContext, "Delete Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Pengadaan>, response: Response<Pengadaan>) {
                if(response.isSuccessful) {
                    startActivity(Intent(this@DetilPengadaanActivity, PengadaanActivity::class.java))

                    Toast.makeText(applicationContext, "Delete Berhasil", Toast.LENGTH_SHORT).show()
                    finish()
                }
                else
                    Toast.makeText(applicationContext, "Delete Gagal", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
