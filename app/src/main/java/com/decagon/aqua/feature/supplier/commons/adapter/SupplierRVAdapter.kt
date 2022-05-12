package com.decagon.aqua.feature.supplier.commons.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.R
import com.decagon.aqua.feature.supplier.commons.model.SupplierRVData

class SupplierRVAdapter(
    val supplierDataList: List<SupplierRVData>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<SupplierRVAdapter.SupplierDataViewHolder>() {
    inner class SupplierDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var supplier_name: TextView = itemView.findViewById(R.id.total_supplies_made_supplier_itemview_name_tv)
        var supplier_address: TextView = itemView.findViewById(R.id.total_supplies_made_supplier_itemview_address_tv)
        var supplier_img: ImageView = itemView.findViewById(R.id.consumer_profile_layout_imageview)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.OnItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupplierDataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.total_supplies_made_supplier_itemview_layout,
            parent, false
        )
        return SupplierDataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SupplierDataViewHolder, position: Int) {
        val currentItem = supplierDataList[position]
        holder.supplier_name.text = currentItem.name
        holder.supplier_address.text = currentItem.address
        holder.supplier_img.setImageResource(currentItem.imgResource)
    }

    override fun getItemCount() = supplierDataList.size
    interface OnItemClickListener {
        fun OnItemClick(position: Int)
    }
}
