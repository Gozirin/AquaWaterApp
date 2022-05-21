package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSupplierLoginBinding
import com.decagon.aqua.feature.consumer.authentication.InputValidation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SupplierLoginFragment : Fragment() {
    private val TAG = "SupplierLoginFragment"
    private lateinit var binding: FragmentSupplierLoginBinding
    private lateinit var receivedEmail: String
    private lateinit var receivedPassword: String
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

            if (!(InputValidation.ValidateEmail(receivedEmail) == null) || (!(InputValidation.validatePassword(receivedPassword) == ""))) {
                Toast.makeText(requireContext(), "Login Credentials are Invalid.", Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(R.id.action_supplierLoginFragment_to_supplier_mainActivity)
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
    }

    fun onPasswordTextChanged(received_Password: String) {
        binding.supplierLoginLayoutPasswordLo.helperText = InputValidation.validatePassword(received_Password)
    }

    fun onEmailTextChanged(received_Email: String) {
        binding.supplierLoginLayoutEmailLo.helperText = InputValidation.ValidateEmail(received_Email)
    }
}
