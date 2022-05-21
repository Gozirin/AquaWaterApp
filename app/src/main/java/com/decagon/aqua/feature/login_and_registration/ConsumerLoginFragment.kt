package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentLoginConsumerBinding
import com.decagon.aqua.feature.consumer.authentication.AquaViewModel
import com.decagon.aqua.feature.consumer.authentication.InputValidation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerLoginFragment : Fragment() {
    private val TAG = "ConsumerLoginFragment"
    private var _binding: FragmentLoginConsumerBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AquaViewModel by viewModels()
    private lateinit var receivedEmail: String
    private lateinit var receivedPassword: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginConsumerBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: Login Fragment")
        binding.consumerLoginLayoutPasswordLo.helperText = ""
        binding.consumerLoginLayoutEmailLo.helperText = ""

        // Sign up if consumer don't have an account
        binding.consumerLoginLayoutLoginSignup.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_consumerSignUpFragment)
        }
        // navigate to consumer forgot password page
        binding.consumerLoginLayoutTextViewForgetPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_consumerForgotPasswordFragment)
        }

        binding.consumerLoginLayoutLoginButton.setOnClickListener {
            receivedEmail = binding.consumerLoginLayoutEditTextEmail.text.toString()
            receivedPassword = binding.consumerLoginLayoutEditTextPassword.text.toString()

            if (!(InputValidation.ValidateEmail(receivedEmail) == null) || (!(InputValidation.validatePassword(receivedPassword) == ""))) {
                Toast.makeText(requireContext(), "Login Credentials are Invalid.", Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(R.id.action_loginFragment_to_consumer_mainActivity)
            }
//            loginRequest(email, password)
//            Log.d(TAG, "Login Button Clicked: $email, $password")
        }
//        AuthenticationPreference().initializePreference(requireActivity())
//        loginResponse()
        binding.consumerLoginLayoutEditTextEmail.addTextChangedListener {
            receivedEmail = binding.consumerLoginLayoutEditTextEmail.text.toString()
            onEmailTextChanged(receivedEmail)
        }
        binding.consumerLoginLayoutEditTextPassword.addTextChangedListener {
            receivedPassword = binding.consumerLoginLayoutEditTextPassword.text.toString()
            onPasswordTextChanged(receivedPassword)
        }
    }
    fun onPasswordTextChanged(received_Password: String): Boolean {
        binding.consumerLoginLayoutPasswordLo.helperText = InputValidation.validatePassword(received_Password)
        return true
    }

    fun onEmailTextChanged(received_Email: String): Boolean {
        binding.consumerLoginLayoutEmailLo.helperText = InputValidation.ValidateEmail(received_Email)
        return true
    }

//    private fun loginRequest(email: String, password: String) {
//        viewModel.loginUser(email, password)
//        Log.d(TAG, "loginRequest: $email, $password")
//    }
//
//    private fun loginResponse() {
//        viewModel.loginResponse.observe(viewLifecycleOwner) {
//            if (it.success) {
//                AuthenticationPreference().saveToken(it.data.token)
//                AuthenticationPreference().saveId(it.data.id)
//                Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
//                Log.d(TAG, "loginResponse:$it ")
//                Log.d(TAG, "loginResponse:${AuthenticationPreference().getToken(AuthenticationPreference.TOKEN_KEY)} ")
//                Log.d(TAG, "loginResponse: ")
//            } else {
//                Toast.makeText(requireContext(), "User has not been registered", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}
