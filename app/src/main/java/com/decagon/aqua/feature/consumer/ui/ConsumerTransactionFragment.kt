package com.decagon.aqua.feature.consumer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.ConsumerTransactionFragmentBinding
import com.decagon.aqua.feature.consumer.adapters.ConsumerTransactionHistoryAdapter
import com.decagon.aqua.models.ConsumerTransactionItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerTransactionFragment : Fragment(), ConsumerTransactionHistoryAdapter.OnItemClickListener {

    private lateinit var binding: ConsumerTransactionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ConsumerTransactionFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ConsumerTransactionFragmentBinding
            .bind(view)

        val adapter = ConsumerTransactionHistoryAdapter(ConsumerTransactionItem().consumerTransactionItem, this)
        binding.transactionHistoryRecyclerView.adapter = adapter

        binding.transactionHistoryBackArrow.setOnClickListener {
            findNavController().navigate(R.id.consumerHomeFragment)
        }
    }

    override fun onItemClick(position: Int) {
    }
}
