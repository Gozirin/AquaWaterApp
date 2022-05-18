package com.decagon.aqua.feature.consumer.ui.consumptionFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSuppliesDetailsBinding
import com.decagon.aqua.feature.consumer.adapters.ConsumerSupplyDetailsAdapter
import com.decagon.aqua.models.SupplyDetailsItem

class SuppliesDetailsFragment : Fragment() {
    private lateinit var binding: FragmentSuppliesDetailsBinding
    private lateinit var newArrayList: ArrayList<SupplyDetailsItem>
    private lateinit var consumerSuppliesDetailAdapter: ConsumerSupplyDetailsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuppliesDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView2()
        getProfiles()
        binding.supplyDetailsContactSellerBtn.setOnClickListener {
            Toast.makeText(this.requireContext(), "Contact Seller", Toast.LENGTH_SHORT).show()
        }
        binding.supplyDetailsCartIcon.setOnClickListener {
            Toast.makeText(this.requireContext(), "Check Cart", Toast.LENGTH_SHORT).show()
        }
        binding.supplyDetailsBellIcon.setOnClickListener {
            Toast.makeText(this.requireContext(), "Check Notification", Toast.LENGTH_SHORT).show()
        }
        binding.supplyDetailsBackBtn.setOnClickListener {
            findNavController().navigate(R.id.action_suppliesDetailsFragment_to_consumerHomeFragment)
        }
    }

    private fun initView2() {
        recyclerView = requireView().findViewById<RecyclerView>(R.id.consumer_supply_details_recyclerView)
        newArrayList = ArrayList()
        consumerSuppliesDetailAdapter = ConsumerSupplyDetailsAdapter(newArrayList)
        recyclerView.adapter = consumerSuppliesDetailAdapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
    }
    private fun getProfiles() {
        newArrayList.add(SupplyDetailsItem(R.drawable.image1, "Bottle Water Pack", "N900", "per/bottle", 9.0, "(9)", "in stock"))
        newArrayList.add(SupplyDetailsItem(R.drawable.image2, "Bottle Water", "N400", "per/bottle", 7.0, "(7.0)", "out of stock"))
        newArrayList.add(SupplyDetailsItem(R.drawable.image3, "Fountain Bottle Water", "N800", "per/bottle", 10.0, "10", "out of stock"))
        newArrayList.add(SupplyDetailsItem(R.drawable.image4, "Eva Bottle Water", "N750", "per/bottle", 6.5, "(6.5)", "in stock"))
        newArrayList.add(SupplyDetailsItem(R.drawable.image4, "Eva Bottle Water", "N750", "per/bottle", 6.5, "(6.5)", "in stock"))
        newArrayList.add(SupplyDetailsItem(R.drawable.image4, "Eva Bottle Water", "N750", "per/bottle", 6.5, "(6.5)", "in stock"))
        newArrayList.add(SupplyDetailsItem(R.drawable.image4, "Eva Bottle Water", "N750", "per/bottle", 6.5, "(6.5)", "in stock"))
        newArrayList.add(SupplyDetailsItem(R.drawable.image4, "Eva Bottle Water", "N750", "per/bottle", 6.5, "(6.5)", "out of stock"))
    }
}
