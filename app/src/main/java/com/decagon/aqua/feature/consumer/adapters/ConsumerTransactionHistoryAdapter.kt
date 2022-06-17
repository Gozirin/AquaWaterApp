package com.decagon.aqua.feature.consumer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.databinding.FragmentTransactionScreenItemListBinding
import com.decagon.aqua.models.TransactionData

class ConsumerTransactionHistoryAdapter(
    val list: List<TransactionData>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<ConsumerTransactionHistoryAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: FragmentTransactionScreenItemListBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        var transaction_name = binding.transactionHistoryScreenNameTV
        var transaction_quantity = binding.transactionHistoryScreenQuantityTV
        var transaction_amount = binding.transactionHistoryAmount
        var transaction_date = binding.transactionHistoryDate
        var transaction_image = binding.transactionHistoryScreenImageTV

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentTransactionScreenItemListBinding.inflate

            (LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.transaction_name.text = currentItem.name
        holder.transaction_quantity.text = currentItem.quantity
        holder.transaction_amount.text = currentItem.amount
        holder.transaction_date.text = currentItem.date
        holder.transaction_image.setImageResource(currentItem.imgResource)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
