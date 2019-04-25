package com.sulcompagnie.si_atmo_mobile.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sulcompagnie.si_atmo_mobile.CRUD.EditSupplierActivity
import com.sulcompagnie.si_atmo_mobile.DAO.Supplier
import com.sulcompagnie.si_atmo_mobile.R
import kotlinx.android.synthetic.main.layout_supplier.view.*

class SupplierAdapter(val supplier: List<Supplier>): RecyclerView.Adapter<SupplierAdapter.SupplierViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupplierViewHolder {
        return SupplierViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_supplier, parent, false)
        )
    }

    override fun getItemCount() = supplier.size

    override fun onBindViewHolder(holder: SupplierViewHolder, position: Int) {
        val supplier =  supplier[position]

//        holder.view.namaPerusahaan.text = "Nama Supplier\t\t:\t" + supplier.namaPerusahaan
//        holder.view.alamatPerusahaan.text = "Alamat Supplier\t\t:\t" + supplier.alamatSupplier
//        holder.view.namaSales.text = "Nama Sales\t\t:\t" + supplier.namaSales
//        holder.view.noTelp.text = "No.Telp\t\t:\t" + supplier.noTelpSales

        holder.view.textNamaPerusahaan.text = supplier.namaPerusahaan
        holder.view.alamatSupplier.text = supplier.alamatSupplier
        holder.view.namaSales.text = supplier.namaSales
        holder.view.noTelpSales.text = supplier.noTelpSales
    }

    class SupplierViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
//                println(view.namaPerusahaan.text)
                val namaPerusahaan = view.textNamaPerusahaan.text.trim()
                val alamatSupplier = view.alamatSupplier.text.trim()
                val namaSales = view.namaSales.text.trim()
                val noTelpSales = view.noTelpSales.text.trim()

                val intent = Intent(view.context, EditSupplierActivity::class.java)

                intent.putExtra("namaPerusahaan", namaPerusahaan)
                intent.putExtra("alamatSupplier", alamatSupplier)
                intent.putExtra("namaSales", namaSales)
                intent.putExtra("noTelpSales", noTelpSales)
                view.context.startActivity(intent)
            }
        }
    }
}