package com.decagon.aqua.feature.consumer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decagon.aqua.databinding.FragmentConsumerTranscationHistoryBinding
import com.decagon.aqua.feature.consumer.adapters.ConsumerTransactionHistoryAdapter
import com.decagon.aqua.models.ConsumerTransactionItem

class ConsumerTransactionHistoryFragment : Fragment(), ConsumerTransactionHistoryAdapter.OnItemClickListener {
    private var _binding: FragmentConsumerTranscationHistoryBinding? = null
    val binding: FragmentConsumerTranscationHistoryBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConsumerTranscationHistoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentConsumerTranscationHistoryBinding
            .bind(view)

        val adapter = ConsumerTransactionHistoryAdapter(ConsumerTransactionItem().consumerTransactionItem, this)
        binding.transactionHistoryRecyclerView.adapter = adapter

        // displaying the recyclerView?/
//        val adapter = ConsumerModalAdapter(ConsumerModalItem().consumerModalItem, this)
//        binding.transactionHistoryRecyclerView.adapter = adapter

        binding.transactionHistoryBackArrow.setOnClickListener {
//            findNavController().navigate(R.id.action_favouriteConsumerFragment2_to_supplierHomePage)
        }
    }

    override fun onItemClick(position: Int) {
        TODO("Not yet implemented")
    }
}
