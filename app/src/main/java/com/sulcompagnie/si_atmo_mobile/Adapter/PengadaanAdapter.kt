package com.sulcompagnie.si_atmo_mobile.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sulcompagnie.si_atmo_mobile.CRUD.DetilPengadaanActivity
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

        holder.view.noPemesanan.text = pengadaan.noPemesanan
        holder.view.textNamaPerusahaan.text = pengadaan.namaPerusahaan
        holder.view.tanggalPemesanan.text = pengadaan.tanggalPemesanan
        holder.view.statusPemesanan.text = pengadaan.statusPemesanan
    }

    class PengadaanViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                //Cek Data
//                println(view.noPemesanan.text)

//                Parsing Data To Another Activity
                val noPemesanan = view.noPemesanan.text.trim()
                val namaPerusahaan = view.textNamaPerusahaan.text.trim()
                val tanggalPemesanan = view.tanggalPemesanan.text.trim()
                val statusPemesanan = view.statusPemesanan.text.trim()

//                println(noPemesanan)
                val intent = Intent(view.context, DetilPengadaanActivity::class.java)

                intent.putExtra("noPemesanan", noPemesanan)
                intent.putExtra("namaPerusahaan", namaPerusahaan)
                intent.putExtra("tanggalPemesanan", tanggalPemesanan)
                intent.putExtra("statusPemesanan", statusPemesanan)
                view.context.startActivity(intent)
            }
        }
    }
}