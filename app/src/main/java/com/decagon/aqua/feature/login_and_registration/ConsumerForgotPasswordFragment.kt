package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initializing view binding
        binding = FragmentConsumerForgotPasswordBinding.bind(view)

        // Back button to return to Login page
        binding.forgotPasswordImageButton1.setOnClickListener {
            findNavController().navigate(R.id.action_consumerForgotPasswordFragment_to_loginFragment)
        }

        // navigate to consumer check mail page
        binding.forgotPasswordButton1.setOnClickListener {
            findNavController().navigate(R.id.action_consumerForgotPasswordFragment_to_consumerCheckMailFragment)
        }
    }
}
