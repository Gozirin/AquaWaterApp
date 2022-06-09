package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentLoggingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerLoginFragment : Fragment() {
    private lateinit var binding: FragmentLoggingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_consumer_login, container, false)
        return binding.rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initializing view binding
        binding = FragmentLoggingBinding.bind(view)
        // Sign up if consumer don't have an account
//        binding.consumerLoginLayoutLoginSignup.setOnClickListener {
//            findNavController().navigate(R.id.action_loginFragment_to_consumerSignUpFragment)
//        }
        // navigate to consumer forgot password page
//        binding.consumerLoginLayoutTextViewForgetPassword.setOnClickListener {
//            findNavController().navigate(R.id.action_loginFragment_to_consumerForgotPasswordFragment)
//        }
//        binding.consumerLoginLayoutLoginButton.setOnClickListener {
//            findNavController().navigate(R.id.action_loginFragment_to_consumer_mainActivity)
//        }
    }
}
