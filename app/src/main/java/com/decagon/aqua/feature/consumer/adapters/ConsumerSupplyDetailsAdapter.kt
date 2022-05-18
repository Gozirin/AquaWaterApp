package com.decagon.aqua.feature.consumer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.* // ktlint-disable no-wildcard-imports
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.R
import com.decagon.aqua.feature.consumer.ui.consumptionFragments.snackbar.CustomSnackbar
import com.decagon.aqua.models.SupplyDetailsItem

class ConsumerSupplyDetailsAdapter(private val consumerItem: ArrayList<SupplyDetailsItem>) :
    RecyclerView.Adapter<ConsumerSupplyDetailsAdapter.ProfileViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.supplies_detail_fragment_item, parent, false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val currentItem = consumerItem[position]
        holder.titleImage.setImageResource(currentItem.image)
        holder.itemName.text = currentItem.itemName
        holder.starRating.rating = currentItem.starRating.toFloat()
        holder.price.text = currentItem.price
        holder.pricePer.text = currentItem.perItem
        holder.rating.text = currentItem.rating
        holder.isStocked.text = currentItem.stock
        holder.itemView.findViewById<AppCompatButton>(R.id.supply_details_add_to_cart_btn).setOnClickListener {

            CustomSnackbar.make(holder.itemView.rootView as ViewGroup).setAnchorView(R.id.supply_details_information).show()
        }
    }

    class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleImage: ImageView = itemView.findViewById(R.id.consumer_suppliesDetail_adapterItem_imageView)
        val itemName: TextView = itemView.findViewById(R.id.consumer_suppliesDetails_adapterItem_itemName_tv)
        val price: TextView = itemView.findViewById(R.id.consumer_suppliesDetail_adapterItem_price_tv)
        val location: TextView = itemView.findViewById(R.id.consumer_suppliesDetails_adapterItem_rating_tv)
        val pricePer: TextView = itemView.findViewById(R.id.consumer_suppliesDetail_adapterItem_pricePer_tv)
        val starRating: RatingBar = itemView.findViewById(R.id.ratingBar)
        val isStocked: TextView = itemView.findViewById(R.id.consumer_suppliesDetail_adapterItem_stock_tv)
        val rating: TextView = itemView.findViewById(R.id.consumer_suppliesDetails_adapterItem_rating_tv)
    }

    override fun getItemCount(): Int = consumerItem.size
}
