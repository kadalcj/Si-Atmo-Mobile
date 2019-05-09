package com.sulcompagnie.si_atmo_mobile.CRUD

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.sulcompagnie.si_atmo_mobile.Adapter.TransaksiSparepartAdapter
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.TransaksiSparepart
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_dash_pencarian_transaksi_sparepart.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashPencarianTransaksiSparepartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_dash_pencarian_transaksi_sparepart)
        setContentView(R.layout.activity_dash_pencarian_transaksi_sparepart)

        refreshLayout.setOnRefreshListener {
            fetchTransaksi()
        }
        fetchTransaksi()
    }

    private fun fetchTransaksi() {
        refreshLayout.isRefreshing = true

        RetrofitClient.instance.getTransSparepart().enqueue(object : Callback<List<TransaksiSparepart>> {
            override fun onFailure(call: Call<List<TransaksiSparepart>>, t: Throwable) {
                refreshLayout.isRefreshing = false
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<TransaksiSparepart>>, response: Response<List<TransaksiSparepart>>) {
                refreshLayout.isRefreshing = false
                val transaksi = response.body()

                transaksi?.let {
                    showTransaksi(it)
                }
            }
        })
    }

    private fun showTransaksi(transaksi: List<TransaksiSparepart>) {
        recycleViewTransaksiSparepart.layoutManager = LinearLayoutManager(this)
        recycleViewTransaksiSparepart.adapter = TransaksiSparepartAdapter(transaksi)
    }
}
