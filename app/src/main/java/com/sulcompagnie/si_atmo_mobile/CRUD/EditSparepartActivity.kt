package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.sulcompagnie.si_atmo_mobile.Api.ApiClient
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.Sparepart
import com.sulcompagnie.si_atmo_mobile.R
import com.sulcompagnie.si_atmo_mobile.SparepartActivity
import kotlinx.android.synthetic.main.activity_edit_sparepart.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class EditSparepartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_sparepart)

        //get Intent
        val intent = intent
        //content of Intent
        val kodeSparepart = intent.getStringExtra("kodeSparepart")
        val namaSparepart = intent.getStringExtra("namaSparepart")
        val tipeSparepart = intent.getStringExtra("tipeSparepart")
        val merkSparepart = intent.getStringExtra("merkSparepart")
        val hargaBeli = intent.getStringExtra("hargaBeli")
        val hargaJual = intent.getStringExtra("hargaJual")

        val btnBatal = findViewById<Button>(R.id.btnBatal)
        val btnEdit = findViewById<Button>(R.id.btnEdit)
        val btnHapus = findViewById<Button>(R.id.btnHapus)

        //Set TextView
        val editKodeSparepart = findViewById<TextView>(R.id.editKodeSparepart)
        val editNamaSparepart = findViewById<TextView>(R.id.editNamaSparepart)
        val editTipeSparepart = findViewById<TextView>(R.id.editTipeSparepart)
        val editMerkSparepart = findViewById<TextView>(R.id.editMerkSparepart)
        val editHargaBeli = findViewById<TextView>(R.id.editHargaBeli)
        val editHargaJual = findViewById<TextView>(R.id.editHargaJual)
        //Set Text in TextView
        editKodeSparepart.text = kodeSparepart
        editNamaSparepart.text = namaSparepart
        editTipeSparepart.text = tipeSparepart
        editMerkSparepart.text = merkSparepart
        editHargaBeli.text = hargaBeli
        editHargaJual.text = hargaJual

        btnBatal.setOnClickListener {
            startActivity(Intent(this@EditSparepartActivity, SparepartActivity::class.java))
            finish()
        }

        btnEdit.setOnClickListener {
//            startActivity(Intent(this@EditSparepartActivity, SparepartActivity::class.java))
//            finish()

            val updateNamaSparepart= editNamaSparepart.text.toString().trim()
            val updateTipeSparepart = editTipeSparepart.text.toString().trim()
            val updateMerkSparepart = editMerkSparepart.text.toString().trim()
            val updateHargaBeli = editHargaBeli.text.toString().trim()
            val updateHargaJual = editHargaJual.text.toString().trim()

            if(kodeSparepart.isEmpty()){
                editKodeSparepart.error = "Kode Sparepart Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if(namaSparepart.isEmpty()){
                editNamaSparepart.error = "Nama Sparepart Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if(tipeSparepart.isEmpty()){
                editTipeSparepart.error = "Tipe Sparepart Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if(merkSparepart.isEmpty()){
                editMerkSparepart.error = "Merk Sparepart Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if(hargaBeli.isEmpty()){
                editHargaBeli.error = "Harga Beli Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if(hargaJual.isEmpty()){
                editHargaJual.error = "Harga Jual Tidak Boleh Kosong"
                return@setOnClickListener
            }

            editSparepart(kodeSparepart, updateNamaSparepart, updateTipeSparepart, updateMerkSparepart, updateHargaBeli, updateHargaJual)
        }

        btnHapus.setOnClickListener {
            println(kodeSparepart.toString())
            deleteSparepart(kodeSparepart)
        }
    }

    private fun editSparepart(kodeSparepart: String, namaSparepart: String, tipeSparepart: String, merkSparepart: String, hargaBeli: String, hargaJual: String) {
        RetrofitClient.instance.editSparepart(kodeSparepart, namaSparepart, tipeSparepart, merkSparepart, hargaBeli, hargaJual).enqueue(object : retrofit2.Callback<Sparepart> {
            override fun onFailure(call: Call<Sparepart>, t: Throwable) {
                Toast.makeText(applicationContext, "Edit Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Sparepart>, response: Response<Sparepart>) {
                if(response.isSuccessful) {
                    startActivity(Intent(this@EditSparepartActivity, SparepartActivity::class.java))

                    Toast.makeText(applicationContext, "Edit Berhasil", Toast.LENGTH_SHORT).show()
                    finish()
                }
                else
                    Toast.makeText(applicationContext, "Edit Gagal", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun deleteSparepart(kodeSparepart: String) {
        RetrofitClient.instance.deleteSparepart(kodeSparepart).enqueue(object : retrofit2.Callback<Sparepart> {
            override fun onFailure(call: Call<Sparepart>, t: Throwable) {
                Toast.makeText(applicationContext, "Delete Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Sparepart>, response: Response<Sparepart>) {
                if(response.isSuccessful) {
                    startActivity(Intent(this@EditSparepartActivity, SparepartActivity::class.java))

                    Toast.makeText(applicationContext, "Delete Berhasil", Toast.LENGTH_SHORT).show()
                    finish()
                }
                else
                    Toast.makeText(applicationContext, "Delete Gagal", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
