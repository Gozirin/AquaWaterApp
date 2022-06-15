package com.decagon.aqua.feature.consumer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.R
import com.decagon.aqua.feature.consumer.ui.ConsumerHomeFragmentDirections
import com.decagon.aqua.models.consumerAuthModule.getcompanieswithfeaturedproduct.PageItem
import com.example.mike_utils.MikeGlide

class ConsumerHomeScreenAdapter :
    RecyclerView.Adapter<ConsumerHomeScreenAdapter.ProfileViewHolder>() {
    private val consumerItem: ArrayList<PageItem> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.consumer_homescreen_adapter_item, parent, false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val currentItem = consumerItem[position]
        MikeGlide.setImage(holder.titleImage, currentItem.product?.photos?.get(0)?.imageUrl)

        holder.companyname.text = currentItem.companyName
        holder.location.text = "${currentItem.location.city}, ${currentItem.location.state}"
        holder.price.text = currentItem.product?.price.toString()
        holder.itemView.setOnClickListener {
            val action = ConsumerHomeFragmentDirections.actionConsumerHomeFragmentToSuppliesDetailsFragment()
            val navController = Navigation.findNavController(holder.itemView)
            navController.navigate(action)
        }
    }

    class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleImage: ImageView = itemView.findViewById(R.id.consumer_adapterItem_imageView)
        val companyname: TextView = itemView.findViewById(R.id.consumer_adapterItem_itemName_tv)
        val location: TextView = itemView.findViewById(R.id.consumer_adapterItem_rating_tv)
        val price: TextView = itemView.findViewById(R.id.consumer_adapterItem_price_tv)
    }

    override fun getItemCount(): Int = consumerItem.size

    fun setProductList(productList: ArrayList<PageItem>) {

        consumerItem.addAll(productList)
    }
}
