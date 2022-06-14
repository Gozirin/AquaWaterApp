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

            if (!InputValidation.validateEmailInput(receivedEmail) || !InputValidation.validateUserPassword(receivedPassword)) {
                Toast.makeText(requireContext(), "Your login credentials are invalid", Toast.LENGTH_SHORT).show()
            } else {
                val login_request = LoginModel(email = receivedEmail, password = receivedPassword)
                viewModel.loginUser(login_request)
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

    private fun onEmailTextChanged(receivedEmail: String) {
        if (InputValidation.validateEmail(receivedEmail) == "Enter a valid Email Address") {
            binding.consumerLoginLayoutEmailLo.helperText = "Enter a valid Email Address"
        } else if (InputValidation.validateEmail(receivedEmail) == "Invalid Email Address") {
            binding.consumerLoginLayoutEmailLo.helperText = "Invalid Email Address"
        } else {
            binding.consumerLoginLayoutEmailLo.helperText = ""
        }
    }

    private fun onPasswordTextChanged(newPassword: String) {
        if (InputValidation.validatePassword(newPassword) == "Password cannot be empty") {
            binding.consumerLoginLayoutPasswordLo.helperText = "Password cannot be empty"
        } else if (InputValidation.validatePassword(newPassword) == "Password must have a minimum of 8 characters.") {
            binding.consumerLoginLayoutPasswordLo.helperText = "Password must have a minimum of 8 characters."
        } else if (InputValidation.validatePassword(newPassword) == "Password must contain at least 1 number.") {
            binding.consumerLoginLayoutPasswordLo.helperText = "Password must contain at least 1 number."
        } else if (InputValidation.validatePassword(newPassword) == "Password must contain at least 1 upper case character.") {
            binding.consumerLoginLayoutPasswordLo.helperText = "Password must contain at least 1 upper case character."
        } else if (InputValidation.validatePassword(newPassword) == "Password must contain at least 1 lower case character.") {
            binding.consumerLoginLayoutPasswordLo.helperText = "Password must contain at least 1 lower case character."
        } else if (InputValidation.validatePassword(newPassword) == "Password must contain at least 1 special character (@#$%&?!).") {
            binding.consumerLoginLayoutPasswordLo.helperText = "Password must contain at least 1 special character (@#$%&?!)."
        } else {
            binding.consumerLoginLayoutPasswordLo.helperText = ""
        }
    }

    fun observeLoginResponse() {
        viewModel.loginResponse.observe(
            viewLifecycleOwner
        ) {
            when (it) {
                is Resource.Success -> {
                    Log.d("Login-succeed", it.message.toString())
                    binding.consumerLoginProgressBar.visibility = View.GONE
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
