package com.sulcompagnie.si_atmo_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.sulcompagnie.si_atmo_mobile.Api.RetrofitClient
import com.sulcompagnie.si_atmo_mobile.DAO.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val email = editUser.text.toString().trim()
            val password = editPass.text.toString().trim()

            authLogin(email, password)
        }
    }

    private fun authLogin(email: String, password: String) {
        RetrofitClient.instance.loginApps(email, password).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful) {
                    startActivity(Intent(this@MainActivity, DashboardActivity::class.java))
                    finish()

                    Toast.makeText(applicationContext, "Selamat Datang Di SiAtmo Mobile", Toast.LENGTH_SHORT).show()
                }
                else
                    Toast.makeText(applicationContext, "Email atau Password Salah", Toast.LENGTH_LONG).show()
            }
        })
    }
}
