package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.Sparepart
import com.sulcompagnie.si_atmo_mobile.R
import com.sulcompagnie.si_atmo_mobile.SparepartActivity
import kotlinx.android.synthetic.main.activity_tambah_sparepart.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahSparepartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_sparepart)

        val actionbar = supportActionBar
        actionbar!!.title = "Tambah Sparepart"

        val btnBatal = findViewById<Button>(R.id.btnBatal)
        val btnTambah = findViewById<Button>(R.id.btnTambah)

        btnBatal.setOnClickListener {
            startActivity(Intent(this@TambahSparepartActivity, SparepartActivity::class.java))
            finish()
        }

        btnTambah.setOnClickListener {
            val kodeSparepart = editKodeSparepart.text.toString().trim()
            val namaSparepart= editNamaSparepart.text.toString().trim()
            val tipeSparepart = editTipeSparepart.text.toString().trim()
            val merkSparepart = editMerkSparepart.text.toString().trim()
            val hargaBeli = editHargaBeli.text.toString().trim()
            val hargaJual = editHargaJual.text.toString().trim()
            val tempatPeletakan = editTempatPeletakan.text.toString().trim()
            val jumlahStok = editJumlahStok.text.toString().trim()

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
            if(tempatPeletakan.isEmpty()){
                editTempatPeletakan.error = "Tempat Peletakan Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if(jumlahStok.isEmpty()){
                editJumlahStok.error = "Jumlah Stok Tidak Boleh Kosong"
                return@setOnClickListener
            }

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
