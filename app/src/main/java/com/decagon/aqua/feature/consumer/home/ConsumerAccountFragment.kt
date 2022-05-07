package com.decagon.aqua.feature.consumer.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.decagon.aqua.core.baseClasses.BaseFragment
import com.decagon.aqua.databinding.FragmentConsumerAccountBinding

class ConsumerAccountFragment : BaseFragment() {

    private lateinit var binding: FragmentConsumerAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConsumerAccountBinding.inflate(inflater, container, false)
        return binding.root
    }
}
