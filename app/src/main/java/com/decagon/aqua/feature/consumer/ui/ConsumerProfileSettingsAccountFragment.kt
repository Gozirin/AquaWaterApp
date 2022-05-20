package com.decagon.aqua.feature.consumer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerProfileSettingsAccountBinding

class ConsumerProfileSettingsAccountFragment : Fragment() {
    private lateinit var binding: FragmentConsumerProfileSettingsAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_consumer_profile_settings_account,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentConsumerProfileSettingsAccountBinding.bind(view)

        binding.consumerProfileSettingsAccountBackTv.setOnClickListener {
            findNavController().navigate(R.id.action_consumerProfileSettingsAccountFragment_to_consumerAccountFragment)
        }
    }
}
