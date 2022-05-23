package com.decagon.aqua.feature.supplier.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSupplierOrdersLayoutBinding
import com.example.tablayout.Adapter
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SupplierOrdersPage : Fragment() {
    private lateinit var binding: FragmentSupplierOrdersLayoutBinding
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController
    lateinit var navHostFragment: NavHostFragment

    var count = 8
    val Tab = arrayOf("Incoming order", "Order history")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_supplier_orders_layout, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSupplierOrdersLayoutBinding.bind(view)
        val pager = binding.consumerIncomingOderViewPager
        val t1 = binding.consumerIncomingOrderTabLayout

        pager.adapter = Adapter(parentFragmentManager, lifecycle)

        TabLayoutMediator(t1, pager) { tab, position ->
            if (position < 1) {
                val badgeDrawable: BadgeDrawable = tab.orCreateBadge
                badgeDrawable.backgroundColor = ContextCompat.getColor(requireContext(), R.color.all_text_color)
                badgeDrawable.isVisible = true
                badgeDrawable.number = count
            }
            tab.text = Tab[position]
        }.attach()
    }
}
