package com.decagon.aqua.feature.consumer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.databinding.FaviouriteConsumerItemDetailsViewBinding
import com.decagon.aqua.feature.supplier.adapter.ConsumerModalData

class ConsumerModalAdapter(
    val list: List<ConsumerModalData>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ConsumerModalAdapter.ViewHolder>() {

    inner class ViewHolder(binding: FaviouriteConsumerItemDetailsViewBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        var consumer_name = binding.consumerModalCardTextViewName
        var consumer_address = binding.consumerModalCardTextViewStreetName
        var consumer_image = binding.consumerModalCardImageViewImage

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
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ConsumerModalAdapter.ViewHolder {
//
        val binding = FaviouriteConsumerItemDetailsViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConsumerModalAdapter.ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.consumer_name.text = currentItem.name
        holder.consumer_address.text = currentItem.address
        holder.consumer_image.setImageResource(currentItem.imgResource)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
