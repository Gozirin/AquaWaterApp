package com.decagon.aqua.feature.consumer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.consumerAccountFragmentMyProfileTv.setOnClickListener {
            findNavController().navigate(R.id.action_consumerAccountFragment_to_consumerProfileSettingsAccountFragment)
        }

        binding.consumerAccountFragmentLogoutTv.setOnClickListener {
        }
    }

    override fun onResume() {
        super.onResume()
    }
}
