package com.sulcompagnie.si_atmo_mobile.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.sulcompagnie.si_atmo_mobile.CRUD.EditSparepartActivity
import com.sulcompagnie.si_atmo_mobile.DAO.Sparepart
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.layout_sparepart.view.*

class SparepartAdapter(val sparepart: List<Sparepart>) : RecyclerView.Adapter<SparepartAdapter.SparepartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SparepartViewHolder {
        return SparepartViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_sparepart, parent, false)
        )
    }

    override fun getItemCount() = sparepart.size

    override fun onBindViewHolder(holder: SparepartViewHolder, position: Int) {
        val sparepart = sparepart[position]

        holder.view.kodeSparepart.text = "Kode Sparepart\t\t:\t" + sparepart.kodeSparepart
        holder.view.namaSparepart.text = "Nama Sparepart\t\t:\t" + sparepart.namaSparepart
        holder.view.tipeSparepart.text = "Tipe Sparepart\t\t:\t" + sparepart.tipeSparepart
        holder.view.merkSparepart.text = "Merk Sparepart\t\t:\t" + sparepart.merkSparepart
        holder.view.hargaBeli.text = "Harga Beli\t\t:\t" + sparepart.hargaBeli
        holder.view.hargaJual.text = "Harga Jual\t\t:\t" + sparepart.hargaJual
        holder.view.tempatPeletakan.text = "Tempat Peletakan\t\t:\t" + sparepart.tempatPeletakan
        holder.view.jumlahStok.text = "Jumlah Stok\t\t:\t" + sparepart.jumlahStok

        holder.view.kodeSparepart.text = sparepart.kodeSparepart
        holder.view.namaSparepart.text = sparepart.namaSparepart
        holder.view.tipeSparepart.text = sparepart.tipeSparepart
        holder.view.merkSparepart.text = sparepart.merkSparepart
        holder.view.hargaBeli.text = sparepart.hargaBeli
        holder.view.hargaJual.text = sparepart.hargaJual
        holder.view.tempatPeletakan.text = sparepart.tempatPeletakan
        holder.view.jumlahStok.text = sparepart.jumlahStok

    }

    class SparepartViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                println(view.kodeSparepart)
                val kodeSparepart = view.kodeSparepart.text.trim()
                val namaSparepart = view.namaSparepart.text.trim()
                val tipeSparepart = view.tipeSparepart.text.trim()
                val merkSparepart = view.merkSparepart.text.trim()
                val hargaBeli = view.hargaBeli.text.trim()
                val hargaJual = view.hargaJual.text.trim()
                val tempatPeletakan = view.tempatPeletakan.text.trim()
                val jumlahStok = view.jumlahStok.text.trim()

                val intent = Intent(view.context, EditSparepartActivity::class.java)

                intent.putExtra("kodeSparepart", kodeSparepart)
                intent.putExtra("namaSparepart", namaSparepart)
                intent.putExtra("tipeSparepart", tipeSparepart)
                intent.putExtra("merkSparepart", merkSparepart)
                intent.putExtra("hargaBeli", hargaBeli)
                intent.putExtra("hargaJual", hargaJual)
                intent.putExtra("tempatPeletakan", tempatPeletakan)
                intent.putExtra("jumlahStok", jumlahStok)
                view.context.startActivity(intent)
            }
        }
    }
}