package com.sulcompagnie.si_atmo_mobile.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sulcompagnie.si_atmo_mobile.DAO.DetilTransaksiSparepart
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.layout_detil_transaksi_sparepart.view.*

class DetilTransaksiSparepartAdapter(val transaksi: List<DetilTransaksiSparepart>) : RecyclerView.Adapter<DetilTransaksiSparepartAdapter.TransaksiViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaksiViewHolder {
        return TransaksiViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_detil_transaksi_sparepart, parent, false)
        )
    }

    override fun getItemCount()= transaksi.size

    override fun onBindViewHolder(holder: TransaksiViewHolder, position: Int) {
        val transaksi = transaksi[position]

        holder.view.textKodeSparepart.text = transaksi.kodeSparepart
        holder.view.textJumlahSparepart.text = transaksi.jumlahSparepart
    }

    class TransaksiViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                Log.d("Testing", "Kepencet Heuheuheu.....")
            }
        }
    }
}