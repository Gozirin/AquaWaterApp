package com.decagon.aqua.feature.supplier.ui.supplierFragments.profileDetailsFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decagon.aqua.databinding.FragmentSupplierProfileDetailsBinding
import com.decagon.aqua.feature.supplier.adapter.SupplierProfileViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class SupplierProfileDetailsFragment : Fragment() {

    private lateinit var binding: FragmentSupplierProfileDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSupplierProfileDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = binding.supplierProfileDetailsTablayout
        val viewPager2 = binding.supplierProfileDetailsViewPager
        val adapter = SupplierProfileViewPagerAdapter(childFragmentManager, lifecycle)

        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Profile Details"
                }
                1 -> {
                    tab.text = "My Products"
                }
            }
        }.attach()
    }
}
