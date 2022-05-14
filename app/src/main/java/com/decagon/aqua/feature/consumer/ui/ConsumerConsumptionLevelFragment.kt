package com.decagon.aqua.feature.consumer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decagon.aqua.databinding.ConsumerConsumptionLevelFragmentBinding
import com.decagon.aqua.feature.consumer.adapters.ConsumptionViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ConsumerConsumptionLevelFragment : Fragment() {

    private lateinit var binding: ConsumerConsumptionLevelFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ConsumerConsumptionLevelFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = binding.consumptionTablayout
        val viewPager2 = binding.consumptionViewPager
        val adapter = ConsumptionViewPagerAdapter(childFragmentManager, lifecycle)

        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "DAY"
                }
                1 -> {
                    tab.text = "WEEK"
                }
                2 -> {
                    tab.text = "MONTH"
                }
                3 -> {
                    tab.text = "YEAR"
                }
            }
        }.attach()
    }
}
