package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.R
import com.sulcompagnie.si_atmo_mobile.SupplierActivity
import kotlinx.android.synthetic.main.activity_tambah_supplier.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.function.Supplier

class TambahSupplierActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_supplier)

        val actionbar = supportActionBar
        actionbar!!.title = "Tambah Supplier"

        val btnBatal = findViewById<Button>(R.id.btnBatal)
        val btnTambah = findViewById<Button>(R.id.btnTambah)

        btnBatal.setOnClickListener {
            startActivity(Intent(this@TambahSupplierActivity, SupplierActivity::class.java))
            finish()
        }

        btnTambah.setOnClickListener {
            val namaPerusahaan = editNamaPerusahaan.text.toString().trim()
            val alamatSupplier = editAlamatSupplier.text.toString().trim()
            val namaSales = editNamaSales.text.toString().trim()
            val noTelpSales = editNoTelpSales.text.toString().trim()

            if(namaPerusahaan.isEmpty()) {
                editNamaPerusahaan.error = "Nama Perusahaan Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if(alamatSupplier.isEmpty()) {
                editAlamatSupplier.error = "Nama Perusahaan Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if(namaSales.isEmpty()) {
                editNamaSales.error = "Nama Perusahaan Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if(noTelpSales.isEmpty()) {
                editNoTelpSales.error = "Nama Perusahaan Tidak Boleh Kosong"
                return@setOnClickListener
            }

            RetrofitClient.instance.storeSupplier(namaPerusahaan, alamatSupplier, namaSales, noTelpSales).enqueue(object :
                Callback<com.sulcompagnie.si_atmo_mobile.DAO.Supplier> {
                override fun onFailure(call: Call<com.sulcompagnie.si_atmo_mobile.DAO.Supplier>, t: Throwable) {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<com.sulcompagnie.si_atmo_mobile.DAO.Supplier>,
                    response: Response<com.sulcompagnie.si_atmo_mobile.DAO.Supplier>
                ) {
                    startActivity(Intent(this@TambahSupplierActivity, SupplierActivity::class.java))
                    finish()
                    Toast.makeText(applicationContext, "Berhasil Tambah Supplier", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
