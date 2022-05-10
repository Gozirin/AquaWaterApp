package com.decagon.aqua.feature.consumer.home.searchFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decagon.aqua.databinding.ConsumerHomepageSearchFragmentBinding


class ConsumerHomepageSearchFragment : Fragment() {

    private lateinit var binding: ConsumerHomepageSearchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ConsumerHomepageSearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}
