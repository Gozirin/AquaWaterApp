package com.decagon.aqua.feature.consumer.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decagon.aqua.core.baseClasses.BaseFragment
import com.decagon.aqua.databinding.FragmentConsumerTransactionBinding

class ConsumerTransactionFragment : BaseFragment() {

    private lateinit var binding: FragmentConsumerTransactionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConsumerTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }
}
