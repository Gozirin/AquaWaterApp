package com.example.tablayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.R

class SupplierOrderHistoryAdapter(
    val orderHistoryList: List<SupplierHistoryRvData>
) : RecyclerView.Adapter<SupplierOrderHistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val orderHistoryView = LayoutInflater.from(parent.context).inflate(R.layout.order_history, parent, false)
        return ViewHolder(orderHistoryView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount() = orderHistoryList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvOrderName = itemView.findViewById<View>(R.id.supplier_order_history_company) as TextView
        val tvOrderQuantity = itemView.findViewById<View>(R.id.supplier_order_history_water_pack) as TextView
        val tvOrderStatus = itemView.findViewById<View>(R.id.supplier_order_history_delivery) as TextView
        val tvOrderDate = itemView.findViewById<View>(R.id.supplier_order_history_delivery_date) as TextView
        val tvOrderImage = itemView.findViewById<View>(R.id.supplier_order_history_image) as ImageView
    }
}
