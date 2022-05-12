package com.decagon.aqua.core.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerForgotPasswordBinding

class ConsumerForgotPasswordFragment : Fragment() {

    private lateinit var binding: FragmentConsumerForgotPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_consumer_forgot_password, container, false)
        return binding.rootView
    }
}
