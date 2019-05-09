package com.sulcompagnie.si_atmo_mobile.Adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sulcompagnie.si_atmo_mobile.DAO.TransaksiSparepart
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.layout_transaksi_sparepart.view.*

class TransaksiSparepartAdapter(val transaksi: List<TransaksiSparepart>) : RecyclerView.Adapter<TransaksiSparepartAdapter.TransaksiViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaksiViewHolder {
        return TransaksiViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_transaksi_sparepart, parent, false)
        )
    }

    override fun getItemCount()= transaksi.size

    override fun onBindViewHolder(holder: TransaksiViewHolder, position: Int) {
        val transaksi = transaksi[position]

        holder.view.textKodeNota.text = transaksi.kodeNota
        holder.view.textTanggalTransaksi.text = transaksi.tanggalTransaksi
        holder.view.textTanggalLunas.text = transaksi.tanggalLunas
        holder.view.textSubTotal.text = transaksi.subTotal
        holder.view.textDiskon.text = transaksi.diskon
        holder.view.textTotal.text = transaksi.total
        holder.view.textStatusTransaksi.text = transaksi.statusTransaksi
        holder.view.textNamaKonsumen.text = transaksi.noTelp
    }

    class TransaksiViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                //Cek Data
                Log.d("Transaksi", view.textKodeNota.text.toString())

                val kodeNota = view.textKodeNota.text.trim()
                val tanggalTransaksi = view.textTanggalTransaksi.text.trim()
                val tanggalLunas = view.textTanggalLunas.text.trim()
                val subTotal = view.textSubTotal.text.trim()
                val diskon = view.textDiskon.text.trim()
                val statusTransaksi = view.textStatusTransaksi.text.trim()
                val total = view.textTotal.text.trim()
                val namaKonsumen = view.textNamaKonsumen.text.trim()

//                val intent = Intent(view.context, ???:class.java)

//                view.context.startActivity(intent)
            }
        }
    }
}