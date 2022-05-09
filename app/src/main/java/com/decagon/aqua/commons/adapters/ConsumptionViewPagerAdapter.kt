package com.decagon.aqua.commons.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.decagon.aqua.feature.consumer.home.consumptionFragments.DayFragment
import com.decagon.aqua.feature.consumer.home.consumptionFragments.MonthFragment
import com.decagon.aqua.feature.consumer.home.consumptionFragments.WeekFragment
import com.decagon.aqua.feature.consumer.home.consumptionFragments.YearFragment

class ConsumptionViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
            0->{
                DayFragment()
            }
            1->{
                WeekFragment()
            }
            2->{
                MonthFragment()
            }
            3->{
                YearFragment()
            }
            else->{
                Fragment()
            }
        }
    }
}