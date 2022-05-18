package com.decagon.aqua.feature.supplier.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.decagon.aqua.feature.supplier.ui.supplierFragments.profileDetailsFragments.SupplierAddProductFragment
import com.decagon.aqua.feature.supplier.ui.supplierFragments.profileDetailsFragments.SupplierEditProfileFragment

class SupplierProfileViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                SupplierEditProfileFragment()
            }
            1 -> {
                SupplierAddProductFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}
