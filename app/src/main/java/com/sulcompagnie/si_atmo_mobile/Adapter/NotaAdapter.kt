package com.sulcompagnie.si_atmo_mobile.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sulcompagnie.si_atmo_mobile.CRUD.WebViewNotaLunasActivity
import com.sulcompagnie.si_atmo_mobile.DAO.Transaksi
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.layout_transaksi.view.*

class NotaAdapter(val transaksi: List<Transaksi>): RecyclerView.Adapter<NotaAdapter.NotaViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        return NotaViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_transaksi, parent, false)
        )
    }

    override fun getItemCount() = transaksi.size

    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val transaksi = transaksi[position]

        holder.view.textKodeTransaksi.text = transaksi.kodeNota
    }

    class NotaViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                val kodeTransaksi = view.textKodeTransaksi.text.trim()

                val intent = Intent(view.context, WebViewNotaLunasActivity::class.java)

                intent.putExtra("kodeNota", kodeTransaksi)

                view.context.startActivity(intent)
            }
        }
    }
}