package com.decagon.aqua.feature.consumer.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.decagon.aqua.feature.supplier.FavouriteConsumerFragment
import com.example.sprint2.ConsumerModalFragment

class ModalAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return FavouriteConsumerFragment()
            1 -> return ConsumerModalFragment()
            else -> return FavouriteConsumerFragment()
        }
    }
}
