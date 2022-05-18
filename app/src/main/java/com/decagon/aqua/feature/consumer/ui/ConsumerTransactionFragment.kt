package com.decagon.aqua.feature.consumer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decagon.aqua.databinding.ConsumerTransactionFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerTransactionFragment : Fragment() {

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
