package com.decagon.aqua.features.consumer.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentLoginConsumerBinding

class CustomerLoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginConsumerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_login_consumer, container, false)
        return binding.rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initializing view binding
        binding = FragmentLoginConsumerBinding.bind(view)
        // Sign up if consumer don't have an account
        val nextbtn = binding.textLoginToSignUp
        nextbtn.setOnClickListener {
            val fragment = ConsumerSignUpFragment() // navigate to login fragment
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_Container, fragment)?.commit()
        }
    }
}
