package com.decagon.aqua.feature.consumer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.R
import com.decagon.aqua.databinding.ConsumerHomeFragmentBinding
import com.decagon.aqua.feature.consumer.adapters.ConsumerHomeScreenAdapter
import com.decagon.aqua.models.DummyConsumerItem

class ConsumerHomeFragment : Fragment() {

    private lateinit var binding: ConsumerHomeFragmentBinding
    private lateinit var newArrayList: ArrayList<DummyConsumerItem>
    private lateinit var consumerHomeScreenAdapter: ConsumerHomeScreenAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ConsumerHomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView2()
        getProfiles()
        binding.consumerHomeFragmentConsumptionSection.setOnClickListener {
            val action = com.decagon.aqua.feature.consumer.ui.ConsumerHomeFragmentDirections.actionConsumerHomeFragmentToConsumerConsumptionLevelFragment()
            findNavController().navigate(action)
        }
    }

    private fun initView2() {
        recyclerView = requireView().findViewById<RecyclerView>(R.id.consumer_home_fragment_recyclerView)
        newArrayList = ArrayList()
        consumerHomeScreenAdapter = ConsumerHomeScreenAdapter(newArrayList)
        recyclerView.adapter = consumerHomeScreenAdapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
    }
    private fun getProfiles() {
        newArrayList.add(DummyConsumerItem(R.drawable.image1, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
        newArrayList.add(DummyConsumerItem(R.drawable.image2, "Regal brothers", "Ikeja, Lagos", "N900.00per/bottle"))
        newArrayList.add(DummyConsumerItem(R.drawable.image3, "Ikechukwu Water Co.", "Ikeja, Lagos", "N900.00per/bottle"))
        newArrayList.add(DummyConsumerItem(R.drawable.image4, "Eva Bottling Co", "Ikeja, Lagos", "N900.00per/bottle"))
        newArrayList.add(DummyConsumerItem(R.drawable.image5, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
        newArrayList.add(DummyConsumerItem(R.drawable.image6, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
        newArrayList.add(DummyConsumerItem(R.drawable.image1, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
        newArrayList.add(DummyConsumerItem(R.drawable.image3, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
    }
}
