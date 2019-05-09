package com.sulcompagnie.si_atmo_mobile.Adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sulcompagnie.si_atmo_mobile.CRUD.DetilTransaksiSparepartActivity
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
        holder.view.textSubTotal.text = transaksi.subtotal
        holder.view.textDiskon.text = transaksi.diskon
        holder.view.textTotal.text = transaksi.total
        holder.view.textStatusTransaksi.text = transaksi.statusTransaksi
        holder.view.textNamaKonsumen.text = transaksi.namaKonsumen
        holder.view.textNoTelp.text = transaksi.noTelpKonsumen
        holder.view.textAlamatKonsumen.text = transaksi.alamatKonsumen
    }

    class TransaksiViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                //Cek Data
                Log.d("Transaksi", view.textKodeNota.text.toString())

                val kodeNota = view.textKodeNota.text.trim()
                val tanggalTransaksi = view.textTanggalTransaksi.text.trim()
                val tanggalLunas: CharSequence
                if(view.textTanggalLunas.text.trim() == "") {
                    tanggalLunas = "Belum Lunas"
                }
                else {
                    tanggalLunas = view.textTanggalLunas.text.trim()
                }
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
                intent.putExtra("tanggalLunas", tanggalLunas)
                intent.putExtra("subTotal", subTotal)
                intent.putExtra("diskon", diskon)
                intent.putExtra("total", total)
                intent.putExtra("statusTransaksi", statusTransaksi)
                intent.putExtra("namaKonsumen", namaKonsumen)
                intent.putExtra("noTelp", noTelp)
                intent.putExtra("alamat", alamatKonsumen)
                view.context.startActivity(intent)
            }
        }
    }
}