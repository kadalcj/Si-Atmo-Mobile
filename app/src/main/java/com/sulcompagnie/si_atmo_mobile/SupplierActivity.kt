package com.sulcompagnie.si_atmo_mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import com.sulcompagnie.si_atmo_mobile.Adapter.SupplierAdapter
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.CRUD.TambahSupplierActivity
import com.sulcompagnie.si_atmo_mobile.DAO.Supplier

import kotlinx.android.synthetic.main.activity_supplier.*
import kotlinx.android.synthetic.main.content_sparepart.*
import kotlinx.android.synthetic.main.content_supplier.*
import kotlinx.android.synthetic.main.content_supplier.refreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class SupplierActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supplier)
        setSupportActionBar(toolbar)

        val actionbar = supportActionBar
        actionbar!!.title = "Dashboard Supplier"
        actionbar.setDisplayHomeAsUpEnabled(true)

        fab.setOnClickListener {
            startActivity(Intent(this@SupplierActivity, TambahSupplierActivity::class.java))
        }

        refreshLayout.setOnRefreshListener {
            fetchSupplier()
        }
        fetchSupplier()
    }

    private fun  fetchSupplier() {
        refreshLayout.isRefreshing = true

        RetrofitClient.instance.getSupplier().enqueue(object : Callback<List<Supplier>> {
            override fun onFailure(call: Call<List<Supplier>>, t: Throwable) {
                refreshLayout.isRefreshing = false
            }

            override fun onResponse(call: Call<List<Supplier>>, response: Response<List<Supplier>>) {
                refreshLayout.isRefreshing = false
                val supplier = response.body()

                supplier?.let {
                    showSupplier(it)
                }
            }
        })
    }

    private fun  showSupplier(supplier: List<Supplier>) {
        recycleViewSupplier.layoutManager = LinearLayoutManager(this)
        recycleViewSupplier.adapter = SupplierAdapter(supplier)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
