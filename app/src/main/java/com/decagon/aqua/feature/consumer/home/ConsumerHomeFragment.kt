package com.decagon.aqua.feature.consumer.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.R
import com.decagon.aqua.commons.adapters.ConsumerHomeScreenAdapter
import com.decagon.aqua.commons.model.ConsumerItem
import com.decagon.aqua.core.baseClasses.BaseFragment
import com.decagon.aqua.databinding.FragmentConsumerHomeFragmentBinding

class ConsumerHomeFragment : BaseFragment() {

    private lateinit var binding: FragmentConsumerHomeFragmentBinding
    private lateinit var newArrayList: ArrayList<ConsumerItem>
    private lateinit var consumerHomeScreenAdapter: ConsumerHomeScreenAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConsumerHomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView2()
        getProfiles()
    }

    private fun initView2() {
        recyclerView = requireView().findViewById<RecyclerView>(R.id.consumer_homeScreen_recyclerView)
        newArrayList = ArrayList()
        consumerHomeScreenAdapter = ConsumerHomeScreenAdapter(newArrayList)
        recyclerView.adapter = consumerHomeScreenAdapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

    }
    private fun getProfiles() {
        newArrayList.add(ConsumerItem(R.drawable.image, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
        newArrayList.add(ConsumerItem(R.drawable.image, "Regal brothers", "Ikeja, Lagos", "N900.00per/bottle"))
        newArrayList.add(ConsumerItem(R.drawable.image, "Ikechukwu Water Co.", "Ikeja, Lagos", "N900.00per/bottle"))
        newArrayList.add(ConsumerItem(R.drawable.image, "Eva Bottling Co", "Ikeja, Lagos", "N900.00per/bottle"))
        newArrayList.add(ConsumerItem(R.drawable.image, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
        newArrayList.add(ConsumerItem(R.drawable.image, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
        newArrayList.add(ConsumerItem(R.drawable.image, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
        newArrayList.add(ConsumerItem(R.drawable.image, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
    }
}
