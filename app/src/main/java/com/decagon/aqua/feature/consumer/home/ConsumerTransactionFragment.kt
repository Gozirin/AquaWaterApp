package com.decagon.aqua.feature.consumer.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.decagon.aqua.core.baseClasses.BaseFragment
import com.decagon.aqua.databinding.ConsumerTransactionFragmentBinding

class ConsumerTransactionFragment : BaseFragment() {

    private lateinit var binding: ConsumerTransactionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ConsumerTransactionFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}
