package com.decagon.aqua.features.consumer.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSignUpConsumerBinding
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
        // navigate to CustomerLoginFragment using the arrow icon
        nextbtn.setOnClickListener {
            val fragment = CustomerLoginFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_Container, fragment)?.commit()
        }
        // Sign in to login fragment if consumer already have an account
        val prev = binding.consumerSignupLayoutTextViewBack
        prev.setOnClickListener {
            val fragment = CustomerLoginFragment() // move back to login fragment
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_Container, fragment)?.commit()
        }
    }
}
