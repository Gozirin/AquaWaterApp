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
import com.decagon.aqua.commons.Resource
import com.decagon.aqua.commons.passCompanyNameToSupplyDetailsFragment
import com.decagon.aqua.databinding.ConsumerHomeFragmentBinding
import com.decagon.aqua.feature.consumer.adapters.ConsumerHomeScreenAdapter
import com.decagon.aqua.feature.login_and_registration.viewmodels.ConsumerViewModel
import com.decagon.aqua.models.consumerAuthModule.consumerhomepage.PageItem
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerHomeFragment : Fragment(), passCompanyNameToSupplyDetailsFragment {

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
        getAllCompaniesWithProducts()
        consumerHomeScreenAdapter = ConsumerHomeScreenAdapter(this)
        Log.d("TAG", "onViewCreated: Welcome to consumer Home screen")
        initRecyclerView2()

        binding.consumerHomeFragmentConsumptionSection.setOnClickListener {
            val action = ConsumerHomeFragmentDirections.actionConsumerHomeFragmentToConsumerConsumptionLevelFragment()
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

    private fun renderProductList(productList: ArrayList<PageItem>) {
        consumerHomeScreenAdapter.setProductList(productList)
    }

    private fun getAllCompaniesWithProducts() {
        viewModel.getCompaniesWithProducts()
        viewModel.products.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { fetchProducts ->
                        Log.d("TAG", "getAllCompaniesWithProducts: $fetchProducts.pageItems ")
                        renderProductList(fetchProducts.pageItems as ArrayList<PageItem>)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
                }
                is Resource.Error -> {
                    response.message?.let {
                        Snackbar.make(
                            requireView(),
                            response.message.toString(),
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
                is Resource.Loading -> {
                    Snackbar.make(requireView(), "Loading!!!!", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun passCompanyNameToSupplyDetails(position: Int, name: String) {
        val actions = ConsumerHomeFragmentDirections.actionConsumerHomeFragmentToSuppliesDetailsFragment(name)
        findNavController().navigate(actions)
    }
}
