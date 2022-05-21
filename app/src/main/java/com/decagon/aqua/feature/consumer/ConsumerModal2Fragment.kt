package com.example.sprint2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerModal2Binding

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ConsumerModal2Fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentConsumerModal2Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_consumer_modal2, container, false)
        return binding.rootView
    }
}
