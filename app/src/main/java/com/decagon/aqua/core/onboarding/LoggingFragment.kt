package com.decagon.aqua.core.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentLoggingBinding

class LoggingFragment : Fragment() {
    private var _binding: FragmentLoggingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoggingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loggingConsumerTv.setOnClickListener {
            findNavController().navigate(R.id.action_loggingFragment_to_loginFragment2)
        }
        binding.loggingSupplierTv.setOnClickListener {
            findNavController().navigate(R.id.action_loggingFragment_to_supplierLoginFragment)
        }
    }
}
