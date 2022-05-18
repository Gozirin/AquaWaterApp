package com.decagon.aqua.feature.consumer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decagon.aqua.databinding.ConsumerAccountFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerAccountFragment : Fragment() {

    private lateinit var binding: ConsumerAccountFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ConsumerAccountFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}
