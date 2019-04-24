package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.Supplier
import com.sulcompagnie.si_atmo_mobile.R
import com.sulcompagnie.si_atmo_mobile.SupplierActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditSupplierActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_supplier)

        //get Intent
        val intent = intent
        //content of Intent
        val namaPerusahaan = intent.getStringExtra("namaPerusahaan")
        val alamatSupplier = intent.getStringExtra("alamatSupplier")
        val namaSales = intent.getStringExtra("namaSales")
        val noTelpSales = intent.getStringExtra("noTelpSales")

        val btnBatal = findViewById<Button>(R.id.btnBatal)
        val btnEdit = findViewById<Button>(R.id.btnEdit)
        val btnHapus = findViewById<Button>(R.id.btnHapus)

        //Set TextView
        val editNamaPerusahaan = findViewById<TextView>(R.id.editNamaPerusahaan)
        val editAlamatSupplier = findViewById<TextView>(R.id.editAlamatSupplier)
        val editNamaSales = findViewById<TextView>(R.id.editNamaSales)
        val editNoTelpSeles = findViewById<TextView>(R.id.editNoTelpSales)
        //Set Text in TextView
        editNamaPerusahaan.text = namaPerusahaan
        editAlamatSupplier.text = alamatSupplier
        editNamaSales.text = namaSales
        editNoTelpSeles.text = noTelpSales

        btnBatal.setOnClickListener {
            startActivity(Intent(this@EditSupplierActivity, SupplierActivity::class.java))
            finish()
        }

        btnEdit.setOnClickListener {
            val updateAlamatSupplier = editAlamatSupplier.text.toString().trim()
            val updateNamaSales = editNamaSales.text.toString().trim()
            val updateNoTelpSales = editNoTelpSeles.text.toString().trim()

            if(alamatSupplier.isEmpty()) {
                editAlamatSupplier.error = "Nama Perusahaan Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if(namaSales.isEmpty()) {
                editNamaSales.error = "Nama Perusahaan Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if(noTelpSales.isEmpty()) {
                editNoTelpSeles.error = "Nama Perusahaan Tidak Boleh Kosong"
                return@setOnClickListener
            }

            editSupplier(namaPerusahaan, updateAlamatSupplier, updateNamaSales, updateNoTelpSales)
        }

        btnHapus.setOnClickListener {
            deleteSupplier(namaPerusahaan)
        }
    }

    private fun editSupplier(namaPerusahaan: String, alamatSupplier: String, namaSales: String, noTelpSales: String) {
        RetrofitClient.instance.editSupplier(namaPerusahaan, alamatSupplier, namaSales, noTelpSales).enqueue(object : Callback<Supplier> {
            override fun onFailure(call: Call<Supplier>, t: Throwable) {
                Toast.makeText(applicationContext, "Edit Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Supplier>, response: Response<Supplier>) {
                if(response.isSuccessful) {
                    startActivity(Intent(this@EditSupplierActivity, SupplierActivity::class.java))

                    Toast.makeText(applicationContext, "Edit Berhasil", Toast.LENGTH_SHORT).show()
                    finish()
                }
                else
                    Toast.makeText(applicationContext, "Edit Gagal", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun deleteSupplier(namaPerusahaan: String) {
        RetrofitClient.instance.deleteSupplier(namaPerusahaan).enqueue(object : Callback<Supplier> {
            override fun onFailure(call: Call<Supplier>, t: Throwable) {
                Toast.makeText(applicationContext, "Delete Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Supplier>, response: Response<Supplier>) {
                if(response.isSuccessful) {
                    startActivity(Intent(this@EditSupplierActivity, SupplierActivity::class.java))

                    Toast.makeText(applicationContext, "Delete Berhasil", Toast.LENGTH_SHORT).show()
                    finish()
                }
                else
                    Toast.makeText(applicationContext, "Delete Gagal", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
