package com.decagon.aqua.feature.supplier.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSupplierHomepageOverviewBinding
import com.decagon.aqua.feature.supplier.TotalSuppliesMade_Supplier
import com.decagon.aqua.feature.supplier.dashboard.home_screen.OrdersReceivedActivityOverview
import com.decagon.aqua.feature.supplier.dashboard.home_screen.SuppliesMadeActivityOverview
import com.example.aqua.ui.FavouriteCustomers

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

        /**
         * to make the layouts on supplier_homepage_overview clickable and to call other fragment
         */
        binding.supplierHomepageOverviewCardview1.setOnClickListener {
            val suppliesMadeActivityOverview = SuppliesMadeActivityOverview()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.supplier_homepage_frame_layout, suppliesMadeActivityOverview)
            transaction.addToBackStack("null")
            transaction.commit()
        }
        binding.supplierHomepageOverviewCardview2.setOnClickListener {
            val ordersReceivedActivityOverview = OrdersReceivedActivityOverview()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.supplier_homepage_frame_layout, ordersReceivedActivityOverview)
            transaction.addToBackStack("null")
            transaction.commit()
        }
        binding.supplierHomepageOverviewCardview3.setOnClickListener {
            val totalsuppliesmadeSupplier = TotalSuppliesMade_Supplier()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.supplier_homepage_frame_layout, totalsuppliesmadeSupplier)
            transaction.addToBackStack("null")
            transaction.commit()
        }
        binding.supplierHomepageOverviewCardview4.setOnClickListener {
            val favouriteCustomers = FavouriteCustomers()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.supplier_homepage_frame_layout, favouriteCustomers)
            transaction.addToBackStack("null")
            transaction.commit()
        }
    }
}
