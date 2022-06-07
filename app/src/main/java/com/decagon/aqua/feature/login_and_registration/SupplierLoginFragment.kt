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
import com.decagon.aqua.commons.util.AuthenticationPreference
import com.decagon.aqua.commons.util.Resource
import com.decagon.aqua.core.data.UserLoginRequest
import com.decagon.aqua.databinding.FragmentSupplierLoginBinding
import com.decagon.aqua.feature.consumer.authentication.AquaViewModel
import com.decagon.aqua.feature.consumer.authentication.InputValidation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SupplierLoginFragment : Fragment() {
    private val TAG = "SupplierLoginFragment"
    private lateinit var binding: FragmentSupplierLoginBinding
    private lateinit var receivedEmail: String
    private lateinit var receivedPassword: String
    private lateinit var errorMsg: TextView
    private val aqua_view_model: AquaViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_supplier_login, container, false)

        return binding.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSupplierLoginBinding.bind(view)
        binding.supplierLoginLayoutPasswordLo.helperText = ""
        binding.supplierLoginLayoutEmailLo.helperText = ""
        errorMsg = binding.supplierLoginErrorMsg

        // navigate to signup page
        binding.supplierLoginLayoutLoginSignup.setOnClickListener {
            findNavController().navigate(R.id.action_supplierLoginFragment_to_supplierSignUpFragment)
        }
        // navigate to supplier forgot password page
        binding.supplierLoginLayoutTextViewForgetPassword.setOnClickListener {
            findNavController().navigate(R.id.action_supplierLoginFragment_to_consumerForgotPasswordFragment)
        }

        binding.supplierLoginLayoutLoginButton.setOnClickListener {
            receivedEmail = binding.supplierLoginLayoutEditTextEmail.text.toString()
            receivedPassword = binding.supplierLoginLayoutEditTextPassword.text.toString()
            val login_request = UserLoginRequest(receivedEmail, receivedPassword)

            if (InputValidation.ValidateEmail(receivedEmail) != null || (InputValidation.validatePassword(receivedPassword) != "")) {
                    binding.supplierLoginLayoutEmailLo.helperText = "Enter a valid Email Address"
                    binding.supplierLoginLayoutPasswordLo.helperText = "Enter a valid Password"
            } else {
                aqua_view_model.loginUser(login_request)
                binding.supplierLoginProgressBar.visibility = View.VISIBLE
            }
        }
        binding.supplierLoginLayoutEditTextEmail.addTextChangedListener {
            receivedEmail = binding.supplierLoginLayoutEditTextEmail.text.toString()
            onEmailTextChanged(receivedEmail)
        }
        binding.supplierLoginLayoutEditTextPassword.addTextChangedListener {
            receivedPassword = binding.supplierLoginLayoutEditTextPassword.text.toString()
            onPasswordTextChanged(receivedPassword)
        }
        observeLoginResponse()
    }

    private fun onPasswordTextChanged(received_Password: String) {
        binding.supplierLoginLayoutPasswordLo.helperText = InputValidation.validatePassword(received_Password)
    }

    private fun onEmailTextChanged(received_Email: String) {
        binding.supplierLoginLayoutEmailLo.helperText = InputValidation.ValidateEmail(received_Email)
    }
    private fun observeLoginResponse() {
        aqua_view_model.loginLiveData.observe(
            viewLifecycleOwner
        ) {
            when (it) {
                is Resource.Success -> {
                    Log.d("Login-succeed", it.value.message)
                    binding.supplierLoginProgressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), it.value.message, Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_supplierLoginFragment_to_supplier_mainActivity)
//                    // Saving auth Token and Id to Shared Preference
//                    AuthenticationPreference.setToken(it.value.data.token)
//                    AuthenticationPreference.setId(it.value.data.id)
//                    //  AuthenticationPreference.setRefreshToken(it.data.refreshToken)

                    // refreshing token from api after 8 mins
//                    val token =
//                        "Bearer ${AuthenticationPreference.getToken(AuthenticationPreference.TOKEN_KEY)}"
//                    val userId = AuthenticationPreference.getId(AuthenticationPreference.ID_KEY)
//                    val refreshKey =
//                        AuthenticationPreference.getRefreshToken(AuthenticationPreference.REFRESH_KEY)
//                    if (userId != null) {
//                        if (refreshKey != null) {
//                            //      refreshTokenCountDown(token, userId, refreshKey)
//                        }
//                    }
                    binding.supplierLoginLayoutLoginButton.text = "Login"
                }
                is Resource.Error -> {
                    binding.supplierLoginProgressBar.visibility = View.GONE
                    errorMsg.text = it.error
                    Log.d("Login400: ", it.error)
                    binding.supplierLoginLayoutLoginButton.text = "Login"
                }
                is Resource.Loading -> {
                    binding.supplierLoginProgressBar.visibility = View.VISIBLE
                }
            }
        }
    }
}
