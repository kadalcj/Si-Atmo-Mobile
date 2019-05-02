package com.sulcompagnie.si_atmo_mobile.Adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sulcompagnie.si_atmo_mobile.DAO.Pengadaan
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.layout_detilpengadaan.view.*

class DetilPengadaanAdapter(val pengadaan: List<Pengadaan>) : RecyclerView.Adapter<DetilPengadaanAdapter.PengadaanViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetilPengadaanAdapter.PengadaanViewHolder {
        return PengadaanViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_detilpengadaan, parent, false)
        )
    }

    override fun getItemCount()= pengadaan.size

    override fun onBindViewHolder(holder: PengadaanViewHolder, position: Int) {
        val pengadaan = pengadaan[position]

        holder.view.textNoPemesanan.text = pengadaan.noPemesanan
        holder.view.textKodeSparepart.text = pengadaan.kodeSparepart
        holder.view.textJumlahPemesanan.text = pengadaan.jumlahPemesanan
        holder.view.textSatuan.text = pengadaan.satuan
    }

    class PengadaanViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                //Nothing to Do
            }
        }
    }
}