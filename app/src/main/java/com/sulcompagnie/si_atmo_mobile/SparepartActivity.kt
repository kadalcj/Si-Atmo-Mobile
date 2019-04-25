package com.sulcompagnie.si_atmo_mobile

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import com.sulcompagnie.si_atmo_mobile.Adapter.SparepartAdapter
import com.sulcompagnie.si_atmo_mobile.Api.ApiClient
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.CRUD.TambahSparepartActivity
import com.sulcompagnie.si_atmo_mobile.DAO.Sparepart

import kotlinx.android.synthetic.main.activity_sparepart.*
import kotlinx.android.synthetic.main.content_sparepart.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SparepartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sparepart)
        setSupportActionBar(toolbar)

        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)

        val btnCari = findViewById<Button>(R.id.btnCari)

        btnCari.setOnClickListener {
            val namaSparepart = editSearch.text.toString().trim()

            searchSparepart(namaSparepart)
        }

        fab.setOnClickListener {
            startActivity(Intent(this@SparepartActivity, TambahSparepartActivity::class.java))
        }

        refreshLayout.setOnRefreshListener {
            fetchSparepart()
        }
        fetchSparepart()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        return super.onCreateOptionsMenu(menu)

        menuInflater.inflate(R.menu.menu_sparepart, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.sortByStok-> {
                sortByStok()
            }

            R.id.sortByHarga-> {
                sortByHarga()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun fetchSparepart() {
        refreshLayout.isRefreshing = true

        RetrofitClient.instance.getSparepart().enqueue(object : Callback<List<Sparepart>> {
            override fun onFailure(call: Call<List<Sparepart>>, t: Throwable) {
                refreshLayout.isRefreshing = false
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Sparepart>>, response: Response<List<Sparepart>>) {
                refreshLayout.isRefreshing = false
                val sparepart = response.body()

                sparepart?.let {
                    showSparepart(it)
                }
            }
        })
    }

    private fun searchSparepart(cari: String) {
        refreshLayout.isRefreshing = true

        RetrofitClient.instance.searchSparepart(cari).enqueue(object : Callback<List<Sparepart>> {
            override fun onFailure(call: Call<List<Sparepart>>, t: Throwable) {
                refreshLayout.isRefreshing = false
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Sparepart>>, response: Response<List<Sparepart>>) {
                refreshLayout.isRefreshing = false
                val sparepart = response.body()

                sparepart?.let {
                    showSparepart(it)
                }
            }
        })
    }

    private fun  showSparepart(sparepart: List<Sparepart>) {
        recycleViewSparepart.layoutManager = LinearLayoutManager(this)
        recycleViewSparepart.adapter = SparepartAdapter(sparepart)
    }

    private fun sortByStok() {
        RetrofitClient.instance.getSparepartByStok().enqueue(object : Callback<List<Sparepart>> {
            override fun onFailure(call: Call<List<Sparepart>>, t: Throwable) {
                refreshLayout.isRefreshing = false
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Sparepart>>, response: Response<List<Sparepart>>) {
                refreshLayout.isRefreshing = false
                val sparepart = response.body()

                sparepart?.let {
                    showSparepart(it)
                }
            }
        })
    }

    private fun sortByHarga() {
        RetrofitClient.instance.getSparepartByHarga().enqueue(object : Callback<List<Sparepart>> {
            override fun onFailure(call: Call<List<Sparepart>>, t: Throwable) {
                refreshLayout.isRefreshing = false
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Sparepart>>, response: Response<List<Sparepart>>) {
                refreshLayout.isRefreshing = false
                val sparepart = response.body()

                sparepart?.let {
                    showSparepart(it)
                }
            }
        })
    }
}
