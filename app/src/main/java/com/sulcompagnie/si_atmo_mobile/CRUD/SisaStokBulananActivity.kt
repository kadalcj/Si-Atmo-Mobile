package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.SpinnerSparepart
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.activity_sisa_stok_bulanan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.sql.Array

class SisaStokBulananActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sisa_stok_bulanan)

        val spinnerDown = findViewById<Spinner>(R.id.spinnerSparepart)

        //Spinner
        RetrofitClient.instance.getSpinnerTipe().enqueue(object : Callback<List<SpinnerSparepart>> {
            override fun onFailure(call: Call<List<SpinnerSparepart>>, t: Throwable) {
                //Nothing to Do
            }

            override fun onResponse(call: Call<List<SpinnerSparepart>>, response: Response<List<SpinnerSparepart>>) {
                val spinnerIsi = response.body()

                val size: Int? = response.body()?.size
                Log.d("Size", size.toString())

                val spinner: ArrayList<String> = ArrayList()

                for (i in 0..5) {
                    spinner.add(spinnerIsi?.get(i)?.tipeSparepart.toString().trim())
                }

                spinnerDown.adapter = ArrayAdapter<String>(this@SisaStokBulananActivity, android.R.layout.simple_spinner_dropdown_item, spinner)
            }
        })

        btnLaporan.setOnClickListener {
            val tahun = editTahun.text.toString()

            if(tahun.isEmpty()){
                editTahun.error = "Kode Sparepart Tidak Boleh Kosong"
                return@setOnClickListener
            }

            val intent = Intent(this, WebViewLaporanSisaStokActivity::class.java)

            intent.putExtra("tahun", tahun)
            intent.putExtra("tipe", spinnerDown.selectedItem.toString().trim())

            startActivity(intent)
        }
    }
}
