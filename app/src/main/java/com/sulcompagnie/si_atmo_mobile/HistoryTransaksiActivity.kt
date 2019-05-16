package com.sulcompagnie.si_atmo_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.sulcompagnie.si_atmo_mobile.Adapter.HistoryAdapter
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.Transaksi
import kotlinx.android.synthetic.main.activity_history_transaksi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryTransaksiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_transaksi)

        btnCari.setOnClickListener {
            val kodePlat = editPlat.text.toString().trim()
            val noTelp = editNoTelp.text.toString().trim()

            fetchHistory(kodePlat, noTelp)
        }
    }

    private fun fetchHistory(kodePlat: String, noTelp: String) {
        refreshLayout.isRefreshing = true

        RetrofitClient.instance.getHistoryTrans(kodePlat, noTelp).enqueue(object : Callback<List<Transaksi>> {
            override fun onFailure(call: Call<List<Transaksi>>, t: Throwable) {
                refreshLayout.isRefreshing = false
                Log.d("FetchHistory", "onFailure")
            }

            override fun onResponse(call: Call<List<Transaksi>>, response: Response<List<Transaksi>>) {
                refreshLayout.isRefreshing = false
                val historyTrans = response.body()

                historyTrans?.let {
                    showHistory(it)
                }
            }
        })
    }

    private fun showHistory(history: List<Transaksi>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = HistoryAdapter(history)
    }
}
