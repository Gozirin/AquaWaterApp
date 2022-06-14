package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.commons.Resource
import com.decagon.aqua.databinding.FragmentConsumerLoginBinding
import com.decagon.aqua.feature.login_and_registration.viewmodels.AuthenticationViewModel
import com.decagon.aqua.models.supplierAuthModule.LoginModel
import com.decagon.aqua.validations.InputValidation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerLoginFragment : Fragment() {
    private val TAG = "ConsumerLoginFragment"
    private lateinit var binding: FragmentConsumerLoginBinding
    private lateinit var userInfo: LoginModel
    private val viewModel: AuthenticationViewModel by viewModels()
    private lateinit var errorMsg: TextView
    private lateinit var receivedEmail: String
    private lateinit var receivedPassword: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_consumer_login, container, false)
        return binding.rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentConsumerLoginBinding.bind(view)
        Log.d(TAG, "onViewCreated: Login Fragment")
        binding.consumerLoginLayoutPasswordLo.helperText = ""
        binding.consumerLoginLayoutEmailLo.helperText = ""
        errorMsg = binding.supplierLoginErrorMsg

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
            val login_request = LoginModel(email = receivedEmail, password = receivedPassword)

            if (InputValidation.ValidateEmail(receivedEmail) != null || (InputValidation.validatePassword(receivedPassword) != "")) {
                binding.consumerLoginLayoutEmailLo.helperText = "Enter a valid Email Address"
                binding.consumerLoginLayoutPasswordLo.helperText = "Enter a valid Password"
                errorMsg.text = null
            } else {
                viewModel.loginUser(login_request)
                binding.consumerLoginProgressBar.visibility = View.VISIBLE
            }
        }

        binding.consumerLoginLayoutEditTextEmail.addTextChangedListener {
            receivedEmail = binding.consumerLoginLayoutEditTextEmail.text.toString()
            onEmailTextChanged(receivedEmail)
            errorMsg.text = null
        }
        binding.consumerLoginLayoutEditTextPassword.addTextChangedListener {
            receivedPassword = binding.consumerLoginLayoutEditTextPassword.text.toString()
            onPasswordTextChanged(receivedPassword)
            errorMsg.text = null
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
        viewModel.loginResponse.observe(
            viewLifecycleOwner
        ) {
            when (it) {
                is Resource.Success -> {
                    Log.d("Login-succeed", it.message.toString())
                    binding.consumerLoginProgressBar.visibility = View.GONE
//                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_loginFragment_to_consumer_mainActivity)
                    binding.consumerLoginLayoutLoginButton.text = "Login"
                }
                is Resource.Error -> {
                    binding.consumerLoginProgressBar.visibility = View.GONE
                    errorMsg.text = it.message.toString()
                    Log.d("Login400: ", it.data?.errors.toString())
                    binding.consumerLoginLayoutLoginButton.text = "Login"
                }
                is Resource.Loading -> {
                    binding.consumerLoginProgressBar.visibility = View.VISIBLE
                }
            }
        }
    }
}
