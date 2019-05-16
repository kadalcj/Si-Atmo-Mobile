package com.sulcompagnie.si_atmo_mobile.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sulcompagnie.si_atmo_mobile.DAO.Transaksi
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.layout_history_transaksi.view.*

class HistoryAdapter(val history: List<Transaksi>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_history_transaksi, parent, false)
        )
    }

    override fun getItemCount() = history.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = history[position]

        holder.view.textKodeNota.text = history.kodeNota
        holder.view.textTanggalTransaksi.text = history.tanggalTransaksi
        holder.view.textPlatNomor.text = history.platNomorKendaraan
        holder.view.textTanggalLunas.text = history.tanggalLunas
        holder.view.textSubTotal.text = history.subtotal
        holder.view.textDiskon.text = history.diskon
        holder.view.textTotal.text = history.total
        holder.view.textStatusTransaksi.text = history.statusTransaksi
        holder.view.textNamaKonsumen.text = history.namaKonsumen
        holder.view.textNoTelp.text = history.noTelpKonsumen
        holder.view.textAlamatKonsumen.text = history.alamatKonsumen
    }

    class HistoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {

            }
        }
    }
}