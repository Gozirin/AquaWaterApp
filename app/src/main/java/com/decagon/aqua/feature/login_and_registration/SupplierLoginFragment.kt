package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.commons.ConnectivityLiveData
import com.decagon.aqua.commons.Resource
import com.decagon.aqua.databinding.FragmentSupplierLoginBinding
import com.decagon.aqua.feature.login_and_registration.viewmodels.AuthenticationViewModel
import com.decagon.aqua.models.supplierAuthModule.LoginModel
import com.decagon.aqua.validations.InputValidation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SupplierLoginFragment : Fragment() {

    private val TAG = "SupplierLoginFragment"
    private lateinit var binding: FragmentSupplierLoginBinding
    private val viewModel: AuthenticationViewModel by viewModels()
    private lateinit var connectivityLiveData: ConnectivityLiveData
    private lateinit var userInfo: LoginModel
    private lateinit var bundle: Bundle
    private lateinit var receivedEmail: String
    private lateinit var receivedPassword: String
    private lateinit var errorMsg: TextView

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
        connectivityLiveData = ConnectivityLiveData(requireActivity().application)
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSupplierLoginBinding.bind(view)
        bundle = Bundle()
        makeCompanyListCall()
        binding.supplierLoginLayoutPasswordLo.helperText = ""
        binding.supplierLoginLayoutEmailLo.helperText = ""
        errorMsg = binding.supplierLoginErrorMsg
        onBackPressed()
        // navigate to supplier forgot password page
        binding.supplierLoginLayoutTextViewForgetPassword.setOnClickListener {
            findNavController().navigate(R.id.action_supplierLoginFragment_to_consumerForgotPasswordFragment)
        }

        binding.supplierLoginSignup.setOnClickListener {
//            viewModel.companyList.observe(requireActivity()) {
//                when (it) {
//                    is Resource.Loading -> {
//                        binding.supplierLoginProgressBar.visibility = View.VISIBLE
//                    }
//                    is Resource.Error -> {
//                        Snackbar.make(view, it.message.toString(), Snackbar.LENGTH_SHORT).setAnchorView(binding.supplierLoginSignup).show()
//                        binding.supplierLoginProgressBar.visibility = View.GONE
//                    }
//                }
//            }
            if (bundle.isEmpty) {
                Toast.makeText(
                    requireContext(),
                    "Please Check your Internet connection",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                findNavController().navigate(
                    R.id.action_supplierLoginFragment_to_supplierSignUpFragment,
                    bundle
                )
            }
        }

        binding.supplierLoginLayoutLoginButton.setOnClickListener {
            receivedEmail = binding.supplierLoginLayoutEditTextEmail.text.toString()
            receivedPassword = binding.supplierLoginLayoutEditTextPassword.text.toString()

            if (InputValidation.ValidateEmail(receivedEmail) != null || (InputValidation.validatePassword(receivedPassword) != "")) {
                binding.supplierLoginLayoutEmailLo.helperText = "Enter a valid Email Address"
                binding.supplierLoginLayoutPasswordLo.helperText = "Enter a valid Password"
                errorMsg.text = null
                Toast.makeText(requireContext(), "Your login credentials are invalid", Toast.LENGTH_SHORT).show()
            } else {
                userInfo = LoginModel(email = receivedEmail, password = receivedPassword)
                viewModel.loginUser(userInfo)
            }
        }
        /**
         * observe the login response
         */
        viewModel.loginResponse.observe(viewLifecycleOwner) {
            // if (it.data?.success == true) {
            when (it) {
                is Resource.Loading -> {
                    binding.supplierLoginProgressBar.visibility = View.VISIBLE
                }
                is Resource.Error -> {
                    errorMsg.text = it.message.toString()
                    binding.supplierLoginProgressBar.visibility = View.GONE
                }
                is Resource.Success -> {
                    if (it.data?.success == true) {
                        errorMsg.text = null
                        binding.supplierLoginProgressBar.visibility = View.GONE
                        findNavController().navigate(R.id.action_supplierLoginFragment_to_supplier_mainActivity)
                    }
                }
            }
        }
        /**
         * add TextChangeListener
         */
        binding.supplierLoginLayoutEditTextEmail.addTextChangedListener {
            receivedEmail = binding.supplierLoginLayoutEditTextEmail.text.toString()
            onEmailTextChanged(receivedEmail)
        }
        binding.supplierLoginLayoutEditTextPassword.addTextChangedListener {
            receivedPassword = binding.supplierLoginLayoutEditTextPassword.text.toString()
            onPasswordTextChanged(receivedPassword)
        }

        connectivityLiveData.observe(
            viewLifecycleOwner,
            Observer { isAvailable ->
                when (isAvailable) {
                    false -> {
                        Toast.makeText(requireContext(), "Please Check your Internet connection", Toast.LENGTH_SHORT).show()
                    }
                    true -> {
                        makeCompanyListCall()
                    }
                }
            }
        )
    }

    private fun makeCompanyListCall() {
        viewModel.getCompanies()
        viewModel.companyList.observe(requireActivity()) {
            when (it) {
                is Resource.Success -> {
                    bundle = Bundle().apply {
                        putSerializable("list", it.data)
                    }
                }
            }
        }
    }
    private fun onPasswordTextChanged(received_Password: String) {
        binding.supplierLoginLayoutPasswordLo.helperText = InputValidation.validatePassword(received_Password)
        errorMsg.text = null
    }

    private fun onEmailTextChanged(received_Email: String) {
        binding.supplierLoginLayoutEmailLo.helperText = InputValidation.ValidateEmail(received_Email)
        errorMsg.text = null
    }

    // Method to handle back press on this Fragment
    private fun onBackPressed() {
        // Overriding onBack press to navigate to home Fragment onBack Pressed
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }
}
