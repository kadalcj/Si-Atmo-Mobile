package com.sulcompagnie.si_atmo_mobile

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import com.sulcompagnie.si_atmo_mobile.Adapter.PengadaanAdapter
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.CRUD.TambahPengadaanActivity
import com.sulcompagnie.si_atmo_mobile.DAO.Pengadaan

import kotlinx.android.synthetic.main.activity_pengadaan.*
import kotlinx.android.synthetic.main.content_pengadaan.*
import kotlinx.android.synthetic.main.content_sparepart.*
import kotlinx.android.synthetic.main.content_supplier.*
import kotlinx.android.synthetic.main.content_supplier.refreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        refreshLayout.setOnRefreshListener {
            fetchPengadaan()
        }
        fetchPengadaan()
    }

    private fun fetchPengadaan() {
        refreshLayout.isRefreshing = true

        RetrofitClient.instance.getPengadaan().enqueue(object : Callback<List<Pengadaan>> {
            override fun onFailure(call: Call<List<Pengadaan>>, t: Throwable) {
                refreshLayout.isRefreshing = false
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Pengadaan>>, response: Response<List<Pengadaan>>) {
                refreshLayout.isRefreshing = false
                val pengadaan = response.body()

                pengadaan?.let {
                    showPengadaan(it)
                }
            }
        })
    }

    private fun showPengadaan(pengadaan: List<Pengadaan>) {
        recycleViewPengadaan.layoutManager = LinearLayoutManager(this)
        recycleViewPengadaan.adapter = PengadaanAdapter(pengadaan)
    }
}
