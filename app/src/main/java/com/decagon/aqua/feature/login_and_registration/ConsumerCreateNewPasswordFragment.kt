package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerCreateNewPasswordBinding

class ConsumerCreateNewPasswordFragment : Fragment() {
    private val TAG = "ConsumerCreateNewPasswordFragment"
    private lateinit var binding: FragmentConsumerCreateNewPasswordBinding
    private val args by navArgs<ConsumerCreateNewPasswordFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_consumer_create_new_password, container, false)
        return binding.rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initializing view binding
        binding = FragmentConsumerCreateNewPasswordBinding.bind(view)
        val email = args.email
        val token = args.token
        Log.d(TAG, "email$email , token$token")

        // Don't have account signup to page.
        binding.createNewTextView6.setOnClickListener {
            findNavController().navigate(R.id.action_consumerCreateNewPasswordFragment_to_supplierSignUpFragment)
        }

        // navigate to password account successful
        binding.createNewButton2.setOnClickListener {
            findNavController().navigate(R.id.action_consumerCreateNewPasswordFragment_to_password_AccountSuccessfulFragment2)
        }
    }
}
