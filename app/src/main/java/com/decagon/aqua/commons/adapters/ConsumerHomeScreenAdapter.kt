package com.decagon.aqua.commons.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.R
import com.decagon.aqua.commons.model.ConsumerItem

class ConsumerHomeScreenAdapter(private val consumerItem: ArrayList<ConsumerItem>) :
    RecyclerView.Adapter<ConsumerHomeScreenAdapter.ProfileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.consumer_homescreen_adapter_item, parent, false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val currentItem = consumerItem[position]
        holder.titleImage.setImageResource(currentItem.image)
        holder.companyname.text = currentItem.company_name
        holder.location.text = currentItem.location
        holder.price.text = currentItem.price
    }

    class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleImage: ImageView = itemView.findViewById(R.id.consumer_homescreen_adapterItem_imageView)
        val companyname: TextView = itemView.findViewById(R.id.consumer_homescreen_adapterItem_companyName_tv)
        val location: TextView = itemView.findViewById(R.id.consumer_homescreen_adapterItem_location_tv)
        val price: TextView = itemView.findViewById(R.id.consumer_homescreen_adapterItem_price_tv)
    }

    override fun getItemCount(): Int = consumerItem.size
}
