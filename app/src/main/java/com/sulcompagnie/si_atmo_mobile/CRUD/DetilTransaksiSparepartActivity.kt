package com.sulcompagnie.si_atmo_mobile.CRUD

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import com.sulcompagnie.si_atmo_mobile.Adapter.DetilTransaksiSparepartAdapter
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.DetilTransaksiSparepart
import com.sulcompagnie.si_atmo_mobile.R

import kotlinx.android.synthetic.main.activity_detil_transaksi_sparepart.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetilTransaksiSparepartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detil_transaksi_sparepart)

        val inten = intent

        val kodeNota = inten.getStringExtra("kodeNota")
        val tanggalTransaksi = inten.getStringExtra("tanggalTransaksi")
        val tanggalLunas = inten.getStringExtra("tanggalLunas")
        val subTotal = inten.getStringExtra("subTotal")
        val diskon = inten.getStringExtra("diskon")
        val total = inten.getStringExtra("total")
        val statusTransaksi = inten.getStringExtra("statusTransaksi")
        val namaKonsumen = inten.getStringExtra("namaKonsumen")
        val noTelp = inten.getStringExtra("noTelp")
        val alamat = inten.getStringExtra("alamat")

        textKodeNota.text = kodeNota
        textTanggalTransaksi.text = tanggalTransaksi
        textTanggalLunas.text = tanggalLunas
        textSubTotal.text = subTotal
        textDiskon.text = diskon
        textTota.text = total
        textStatusTransaksi.text = statusTransaksi
        textNamaKonsumen.text = namaKonsumen
        textNoTelp.text = noTelp
        textAlamatKonsumen.text = alamat

        refreshLayout.setOnRefreshListener {
            fetchDetil(kodeNota)
        }

        fetchDetil(kodeNota)
    }

    private fun fetchDetil(kodeNota: String) {
        refreshLayout.isRefreshing = true

        RetrofitClient.instance.getDetilTransSparepart(kodeNota).enqueue(object : Callback<List<DetilTransaksiSparepart>> {
            override fun onFailure(call: Call<List<DetilTransaksiSparepart>>, t: Throwable) {
                refreshLayout.isRefreshing = false
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<DetilTransaksiSparepart>>, response: Response<List<DetilTransaksiSparepart>>) {
                refreshLayout.isRefreshing = false
                val detilTransaksi = response.body()

                detilTransaksi?.let {
                    showDetil(it)
                }
            }
        })
    }

    private fun showDetil(detilTransaksi: List<DetilTransaksiSparepart>) {
        recycleViewDetil.layoutManager = LinearLayoutManager(this)
        recycleViewDetil.adapter = DetilTransaksiSparepartAdapter(detilTransaksi)
    }
}
