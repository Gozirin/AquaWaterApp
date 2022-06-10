package com.decagon.aqua.feature.consumer.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.R
import com.decagon.aqua.databinding.ConsumerHomeFragmentBinding
import com.decagon.aqua.feature.consumer.adapters.ConsumerHomeScreenAdapter
import com.decagon.aqua.feature.login_and_registration.viewmodels.ConsumerViewModel
import com.decagon.aqua.models.consumerAuthModule.CompaniesWithProducts
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerHomeFragment : Fragment() {

    private lateinit var binding: ConsumerHomeFragmentBinding
    private val viewModel: ConsumerViewModel by viewModels()
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
        consumerHomeScreenAdapter = ConsumerHomeScreenAdapter()
        Log.d("TAG", "onViewCreated: Welcome to consumer Home screen")
        initRecyclerView2()
        getAllCompaniesWithProducts()

        binding.consumerHomeFragmentConsumptionSection.setOnClickListener {
            val action = com.decagon.aqua.feature.consumer.ui.ConsumerHomeFragmentDirections.actionConsumerHomeFragmentToConsumerConsumptionLevelFragment()
            findNavController().navigate(action)
        }
    }

    private fun initRecyclerView2() {
        recyclerView = binding.consumerHomeFragmentRecyclerView
        recyclerView.adapter = consumerHomeScreenAdapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
    }
//    private fun getProfiles() {
//        newArrayList.add(DummyConsumerItem(R.drawable.water_circle, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
//        newArrayList.add(DummyConsumerItem(R.drawable.water_circle, "Regal brothers", "Ikeja, Lagos", "N900.00per/bottle"))
//        newArrayList.add(DummyConsumerItem(R.drawable.water_circle, "Ikechukwu Water Co.", "Ikeja, Lagos", "N900.00per/bottle"))
//        newArrayList.add(DummyConsumerItem(R.drawable.water_circle, "Eva Bottling Co", "Ikeja, Lagos", "N900.00per/bottle"))
//        newArrayList.add(DummyConsumerItem(R.drawable.water_circle, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
//        newArrayList.add(DummyConsumerItem(R.drawable.water_circle, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
//        newArrayList.add(DummyConsumerItem(R.drawable.water_circle, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
//        newArrayList.add(DummyConsumerItem(R.drawable.water_circle, "Arizona Water Inc", "Ikeja, Lagos", "N900.00per/bottle"))
//    }

    private fun renderProductList(productList: ArrayList<CompaniesWithProducts>) {
        consumerHomeScreenAdapter.setProductList(productList)
    }

    private fun getAllCompaniesWithProducts() {
        viewModel.getCompaniesWithProducts()
        viewModel.products.observe(viewLifecycleOwner) { fetchProducts ->
            if (fetchProducts.data != null) {
                Log.d("TAG", "getAllCompaniesWithProducts$fetchProducts")
                renderProductList(arrayListOf(fetchProducts.data))
            } else {
                Snackbar.make(requireView(), fetchProducts.message.toString(), Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}
