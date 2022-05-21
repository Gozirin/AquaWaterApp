package com.example.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablayout.fragment.IncomingFragment
import com.example.tablayout.fragment.OrderFragment

class Adapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2

    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return IncomingFragment()
            1 -> return OrderFragment()
            else -> return IncomingFragment()
        }

    }




}