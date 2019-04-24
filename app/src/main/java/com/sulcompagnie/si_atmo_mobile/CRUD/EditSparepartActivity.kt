package com.sulcompagnie.si_atmo_mobile.CRUD

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

        val btnBatal = findViewById<Button>(R.id.btnBatal)
        val btnEdit = findViewById<Button>(R.id.btnEdit)
        val btnHapus = findViewById<Button>(R.id.btnHapus)

        btnBatal.setOnClickListener {
            startActivity(Intent(this@EditSparepartActivity, SparepartActivity::class.java))
            finish()
        }

        btnEdit.setOnClickListener {
            startActivity(Intent(this@EditSparepartActivity, SparepartActivity::class.java))
            finish()
        }

        btnHapus.setOnClickListener {
            println(kodeSparepart.toString())
            deleteSparepart(kodeSparepart)
        }
    }

    private fun deleteSparepart(kodeSparepart: String) {
//        ApiClient().deleteSparepart(kodeSparepart).enqueue(object : retrofit2.Callback<Sparepart> {
//            override fun onFailure(call: Call<Sparepart>, t: Throwable) {
//                Toast.makeText(applicationContext, "Delete Error", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onResponse(call: Call<Sparepart>, response: Response<Sparepart>) {
//                if(response.isSuccessful) {
//                    startActivity(Intent(this@EditSparepartActivity, SparepartActivity::class.java))
//
//                    Toast.makeText(applicationContext, "Delete Berhasil", Toast.LENGTH_SHORT).show()
//                    finish()
//                }
//                else
//                    Toast.makeText(applicationContext, "Delete Gagal", Toast.LENGTH_SHORT).show()
//            }
//        })

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
