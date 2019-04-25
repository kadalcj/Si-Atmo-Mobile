package com.sulcompagnie.si_atmo_mobile.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sulcompagnie.si_atmo_mobile.DAO.Pengadaan
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.layout_pengadaan.view.*

class PengadaanAdapter(val pengadaan: List<Pengadaan>) : RecyclerView.Adapter<PengadaanAdapter.PengadaanViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PengadaanViewHolder {
        return PengadaanViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_pengadaan, parent, false)
        )
    }

    override fun getItemCount()= pengadaan.size

    override fun onBindViewHolder(holder: PengadaanViewHolder, position: Int) {
        val pengadaan = pengadaan[position]

        holder.view.namaPerusahaan.text = pengadaan.namaPerusahaan
        holder.view.tanggalPemesanan.text = pengadaan.tanggalPemesanan
        holder.view.statusPemesanan.text = pengadaan.statusPemesanan
    }

    class PengadaanViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                println(view.tanggalPemesanan.text)

//                val namaPerusahaan = view.namaPerusahaan
//                val tanggalPemesanan = view.tanggalPemesanan
//                val statusPemesanan = view.statusPemesanan

//                val intent = Intent(view.context, EditPengadaanActivity::class.java)

//                intent.putExtra("namaPerusahaan", namaPerusahaan)
//                intent.putExtra("tanggalPemesanan", tanggalPemesanan)
//                intent.putExtra("statusPemesanan", statusPemesanan)
//                view.context.startActivity(intent)
            }
        }
    }
}