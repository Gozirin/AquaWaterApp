package com.decagon.aqua.feature.consumer.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.* // ktlint-disable no-wildcard-imports
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.decagon.aqua.R
import com.decagon.aqua.feature.consumer.ui.consumptionFragments.snackbar.CustomSnackbar
import com.decagon.aqua.models.companyProductmodel.ProductData

class ConsumerSupplyDetailsAdapter() :
    RecyclerView.Adapter<ConsumerSupplyDetailsAdapter.ProfileViewHolder>() {
    private val consumerItem: ArrayList<ProductData> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.supplies_detail_fragment_item, parent, false)
        return ProfileViewHolder(itemView)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val currentItem = consumerItem[position]
/*
        holder.titleImage.apply {
            Glide.with(this)
                .load("https://aquawaterapp.herokuapp.com/swagger/api/Product/GetProductsByCompanyID")
//                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/${position + 1}.png")
                .into(holder.titleImage)
        }

 */

        Glide
            .with(holder.itemView)
            .load(currentItem.photos[0].imageUrl)
            .into(holder.titleImage)
        holder.itemName.text = currentItem.name
        holder.starRating.rating = currentItem.rating.toFloat()
        holder.price.text = currentItem.price.toString()
        holder.rating.text = currentItem.noOfRating.toString()
        holder.isStocked.text = currentItem.inStock.toString()
        holder.itemView.findViewById<AppCompatButton>(R.id.supply_details_add_to_cart_btn).setOnClickListener {

            CustomSnackbar.make(holder.itemView.rootView as ViewGroup).setAnchorView(R.id.supply_details_information).show()
        }
        holder.likeBtn.setOnClickListener {
            holder.likeBtn.visibility = View.GONE
            holder.likeBtn2.visibility = View.VISIBLE
        }
        holder.likeBtn2.setOnClickListener {
            holder.likeBtn2.visibility = View.GONE
            holder.likeBtn.visibility = View.VISIBLE
        }
    }

    class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleImage: ImageView = itemView.findViewById(R.id.consumer_suppliesDetail_adapterItem_imageView)
        val itemName: TextView = itemView.findViewById(R.id.consumer_suppliesDetails_adapterItem_itemName_tv)
        val price: TextView = itemView.findViewById(R.id.consumer_suppliesDetail_adapterItem_price_tv)
        val location: TextView = itemView.findViewById(R.id.consumer_suppliesDetails_adapterItem_rating_tv)
        // val pricePer: TextView = itemView.findViewById(R.id.consumer_suppliesDetail_adapterItem_pricePer_tv)
        val starRating: RatingBar = itemView.findViewById(R.id.ratingBar)
        val isStocked: TextView = itemView.findViewById(R.id.consumer_suppliesDetail_adapterItem_stock_tv)
        val rating: TextView = itemView.findViewById(R.id.consumer_suppliesDetails_adapterItem_rating_tv)
        val likeBtn: Button = itemView.findViewById(R.id.likebtn)
        val likeBtn2: Button = itemView.findViewById(R.id.likebtn2)
    }

    override fun getItemCount(): Int = consumerItem.size

    fun setProducts(products: ArrayList<ProductData>) {
        consumerItem.addAll(products)
    }
}
