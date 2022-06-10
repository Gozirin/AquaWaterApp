package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerLoginBinding
import com.decagon.aqua.feature.login_and_registration.viewmodels.AuthenticationViewModel
import com.decagon.aqua.models.supplierAuthModule.LoginModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerLoginFragment : Fragment() {
    private var _binding: FragmentConsumerLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthenticationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentConsumerLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.consumerLoginSignup.setOnClickListener {
            findNavController().navigate(R.id.action_consumerLoginFragment_to_consumerSignUpFragment)
        }

        binding.consumerLoginLayoutLoginButton.setOnClickListener {
            val email = binding.consumerLoginLayoutEditTextEmail.text.toString()
            val password = binding.consumerLoginLayoutEditTextPassword.text.toString()
            val consumerInfo = LoginModel(email = email, password = password)
            viewModel.loginUser(consumerInfo)
            Log.d("XXX", "onViewCreated: consumer login $consumerInfo")
            viewModel.loginResponse.observe(viewLifecycleOwner) {
                if (it.data?.success == true) {
                    findNavController().navigate(R.id.action_consumerLoginFragment_to_consumer_mainActivity)
                }
            }
        }
    }
}
