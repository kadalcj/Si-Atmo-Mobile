package com.sulcompagnie.si_atmo_mobile.CRUD

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.sulcompagnie.si_atmo_mobile.Adapter.NotaAdapter
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.Transaksi
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_nota_lunas.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotaLunasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota_lunas)

        getTransaksi()
    }

    private fun getTransaksi() {
        RetrofitClient.instance.getKodeNotaFull().enqueue(object : Callback<List<Transaksi>> {
            override fun onFailure(call: Call<List<Transaksi>>, t: Throwable) {
                //Nothing to Do
            }

            override fun onResponse(call: Call<List<Transaksi>>, response: Response<List<Transaksi>>) {
                val transaksi = response.body()

                Log.d("List Surat Kode", transaksi.toString())

                transaksi?.let {
                    showTransaksi(it)
                }
            }
        })
    }

    private fun showTransaksi(transaksi: List<Transaksi>) {
        recyclerViewNota.layoutManager = LinearLayoutManager(this)
        recyclerViewNota.adapter = NotaAdapter(transaksi)
    }
}
