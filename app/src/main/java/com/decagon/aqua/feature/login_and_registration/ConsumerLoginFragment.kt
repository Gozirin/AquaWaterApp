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
import com.decagon.aqua.core.data.UserLoginRequest
import com.decagon.aqua.databinding.FragmentLoginConsumerBinding
import com.decagon.aqua.feature.consumer.authentication.AquaViewModel
import com.decagon.aqua.feature.consumer.authentication.InputValidation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerLoginFragment : Fragment() {
    private val TAG = "ConsumerLoginFragment"
    private var _binding: FragmentLoginConsumerBinding? = null
    private val binding get() = _binding!!
    // private val viewModel: AquaViewModel by viewModels()
    private val aqua_view_model: AquaViewModel by viewModels()
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
            val login_request = UserLoginRequest(receivedEmail, receivedPassword)

            if (InputValidation.ValidateEmail(receivedEmail) != null || (InputValidation.validatePassword(receivedPassword) != "")) {
                Toast.makeText(
                    requireContext(),
                    "Login Credentials are Invalid.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                aqua_view_model.loginUser(login_request)
                binding.consumerLoginProgressBar.visibility = View.VISIBLE
            }
        }

        binding.consumerLoginLayoutEditTextEmail.addTextChangedListener {
            receivedEmail = binding.consumerLoginLayoutEditTextEmail.text.toString()
            onEmailTextChanged(receivedEmail)
        }
        binding.consumerLoginLayoutEditTextPassword.addTextChangedListener {
            receivedPassword = binding.consumerLoginLayoutEditTextPassword.text.toString()
            onPasswordTextChanged(receivedPassword)
        }
        observeLoginResponse()
    }
    fun onPasswordTextChanged(received_Password: String): Boolean {
        binding.consumerLoginLayoutPasswordLo.helperText = InputValidation.validatePassword(received_Password)
        return true
    }

    fun onEmailTextChanged(received_Email: String): Boolean {
        binding.consumerLoginLayoutEmailLo.helperText = InputValidation.ValidateEmail(received_Email)
        return true
    }
    fun observeLoginResponse() {
        aqua_view_model.loginLiveData.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_loginFragment_to_consumer_mainActivity)
//            Log.d(TAG, "observeLoginResponse: $it")
//            Toast.makeText(requireContext(), "$it", Toast.LENGTH_LONG).show()
        }
    }
}
