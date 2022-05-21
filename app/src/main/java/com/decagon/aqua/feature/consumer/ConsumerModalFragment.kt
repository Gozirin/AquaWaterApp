package com.example.sprint2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerModalBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ConsumerModalFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentConsumerModalBinding? = null
    val binding: FragmentConsumerModalBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentConsumerModalBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.consumerModalButton.setOnClickListener {


            findNavController().navigate(R.id.action_consumerModalFragment_to_consumerModal2Fragment)
        }
    }
}
