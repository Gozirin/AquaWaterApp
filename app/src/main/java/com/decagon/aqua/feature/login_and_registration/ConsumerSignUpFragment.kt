package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSignUpConsumerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerSignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpConsumerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_sign_up_consumer, container, false)
        return binding.rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initializing view binding
        binding = FragmentSignUpConsumerBinding.bind(view)
        val nextbtn = binding.consumerSignupLayoutTextViewSignIn
        // navigate to ConsumerLoginFragment using the arrow icon
        nextbtn.setOnClickListener {
            findNavController().navigate(R.id.action_consumerSignUpFragment_to_loginFragment)
        }
        // Sign in to login fragment if consumer already have an account

        binding.consumerSignupLayoutTextViewBack.setOnClickListener {
            findNavController().navigate(R.id.action_consumerSignUpFragment_to_loginFragment)
        }
        binding.consumerSignupLayoutButtonSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_consumerSignUpFragment_to_consumer_mainActivity)
        }
    }
}
