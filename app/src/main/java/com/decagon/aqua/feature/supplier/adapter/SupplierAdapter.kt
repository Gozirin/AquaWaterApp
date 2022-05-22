package com.example.tablayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.R

class SupplierAdapter(
    val list: List<SupplierRvData>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<SupplierAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.incoming_order, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SupplierAdapter.ViewHolder, position: Int) {
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val tvSupplierName = itemView.findViewById<View>(R.id.total_supplies_made_supplier_itemview_name_tv) as TextView
        val tvSupplierPurchase = itemView.findViewById<View>(R.id.total_supplies_made_supplier_itemview_purchaseItem_tv) as TextView
        val supplierAddress = itemView.findViewById<View>(R.id.supplier_address_tv) as TextView
        val supplierPurchaseDate = itemView.findViewById<View>(R.id.supplier_purchase_date) as TextView
        val supplierQuantityPurchase = itemView.findViewById<View>(R.id.supplier_quantity_purchase) as TextView
        val supplierImage = itemView.findViewById<View>(R.id.total_supplies_made_supplier_itemview_imageview) as ImageView
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
