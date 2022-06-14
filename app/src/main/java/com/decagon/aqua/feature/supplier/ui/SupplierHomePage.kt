package com.decagon.aqua.feature.supplier.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSupplierHomepageOverviewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SupplierHomePage : Fragment() {

    private lateinit var binding: FragmentSupplierHomepageOverviewBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_supplier_homepage_overview, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSupplierHomepageOverviewBinding.bind(view)

        binding.supplierHomepageOverviewCardview1.setOnClickListener {
            findNavController().navigate(R.id.action_supplierHomePage_to_suppliesMadeFragment)
        }
        binding.supplierHomepageOverviewCardview2.setOnClickListener {
        }
        binding.supplierHomepageOverviewCardview3.setOnClickListener {
            findNavController().navigate(R.id.action_supplierHomePage_to_pastSuppilesFragement)
        }
        binding.supplierHomepageOverviewCardview4.setOnClickListener {
            findNavController().navigate(R.id.action_supplierHomePage_to_favouriteConsumerFragment2)
        }
    }
}
