package com.sulcompagnie.si_atmo_mobile.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sulcompagnie.si_atmo_mobile.CRUD.DetilTransaksiSparepartActivity
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
                val kodeNota = view.textKodeNota.text.trim()
                val tanggalTransaksi = view.textTanggalTransaksi.text.trim()
                val platNomor = view.textPlatNomor.text.trim()
                val tanggalLunas = view.textTanggalLunas.text.trim()
                val subTotal = view.textSubTotal.text.trim()
                val diskon = view.textDiskon.text.trim()
                val total = view.textTotal.text.trim()
                val statusTransaksi = view.textStatusTransaksi.text.trim()
                val namaKonsumen = view.textNamaKonsumen.text.trim()
                val noTelp = view.textNoTelp.text.trim()
                val alamatKonsumen = view.textAlamatKonsumen.text.trim()

                val intent = Intent(view.context, DetilTransaksiSparepartActivity::class.java)

                intent.putExtra("kodeNota", kodeNota)
                intent.putExtra("tanggalTransaksi", tanggalTransaksi)
                intent.putExtra("platNomor", platNomor)
                intent.putExtra("tanggalLunas", tanggalLunas)
                intent.putExtra("subTotal", subTotal)
                intent.putExtra("diskon", diskon)
                intent.putExtra("total", total)
                intent.putExtra("statusTransaksi", statusTransaksi)
                intent.putExtra("namaKonsumen", namaKonsumen)
                intent.putExtra("noTelp", noTelp)
                intent.putExtra("alamatKonsumen", alamatKonsumen)

                view.context.startActivity(intent)
            }
        }
    }
}