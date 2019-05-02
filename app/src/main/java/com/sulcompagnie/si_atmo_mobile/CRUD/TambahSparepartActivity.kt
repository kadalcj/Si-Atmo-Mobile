package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.Sparepart
import com.sulcompagnie.si_atmo_mobile.R
import com.sulcompagnie.si_atmo_mobile.SparepartActivity
import kotlinx.android.synthetic.main.activity_tambah_sparepart.*
import kotlinx.android.synthetic.main.layout_sparepart.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahSparepartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_sparepart)

        val actionbar = supportActionBar
        actionbar!!.title = "Tambah Sparepart"

        val spinKode1 = findViewById<Spinner>(R.id.spinKode1)
        val kode1 = arrayOf("DPN", "TGH", "BLK")

        val spinKode2 = findViewById<Spinner>(R.id.spinKode2)
        val kode2 = arrayOf("KACA", "DUS", "BAN", "KAYU")

        val btnBatal = findViewById<Button>(R.id.btnBatal)
        val btnTambah = findViewById<Button>(R.id.btnTambah)

        spinKode1.adapter = ArrayAdapter<String>(this@TambahSparepartActivity, android.R.layout.simple_spinner_dropdown_item, kode1)
        spinKode2.adapter = ArrayAdapter<String>(this@TambahSparepartActivity, android.R.layout.simple_spinner_dropdown_item, kode2)

        btnBatal.setOnClickListener {
            startActivity(Intent(this@TambahSparepartActivity, SparepartActivity::class.java))
            finish()
        }

        btnTambah.setOnClickListener {
            val kodeSparepart = spinKode1.selectedItem.toString().trim() + "-" + spinKode2.selectedItem.toString().trim() + "-" + editNomor.text.toString().trim()
            val namaSparepart = editNamaSparepart.text.toString().trim()
            val tipeSparepart = editTipeSparepart.text.toString().trim()
            val merkSparepart = editMerkSparepart.text.toString().trim()
            val hargaBeli = editHargaBeli.text.toString().trim()
            val hargaJual = editHargaJual.text.toString().trim()
            val tempatPeletakan = spinKode1.selectedItem.toString().trim()
            val jumlahStok = 0

            if(kodeSparepart.isEmpty()){
                editNomor.error = "Kode Sparepart Tidak Boleh Kosong"
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

//            Cek Concatenation
//            Log.d("TAG", kodeSparepart)

            RetrofitClient.instance.storeSparepart(kodeSparepart, namaSparepart, tipeSparepart, merkSparepart, hargaBeli, hargaJual, tempatPeletakan, jumlahStok)
                .enqueue(object: Callback<Sparepart> {
                    override fun onFailure(call: Call<Sparepart>, t: Throwable) {
                        Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<Sparepart>, response: Response<Sparepart>) {
                        startActivity(Intent(this@TambahSparepartActivity, SparepartActivity::class.java))
                        finish()
                        Toast.makeText(applicationContext, "Berhasil Tambah Supplier", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}
