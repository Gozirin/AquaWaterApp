package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SupplierLoginFragment : Fragment() {

    private lateinit var binding: FragmentSupplierLoginBinding
    private val viewModel: AuthenticationViewModel by viewModels()
    private lateinit var connectivityLiveData: ConnectivityLiveData
    private lateinit var userInfo: LoginModel
    private lateinit var bundle: Bundle

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = inflater.inflate(R.layout.fragment_supplier_login, container, false)
        return binding.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        connectivityLiveData = ConnectivityLiveData(requireActivity().application)
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSupplierLoginBinding.bind(view)
        bundle = Bundle()
        makeCompanyListCall()

        binding.supplierLoginSignup.setOnClickListener {
            if (bundle.isEmpty) {
                Toast.makeText(requireContext(), "Please Check your Internet connection", Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(R.id.action_supplierLoginFragment_to_supplierSignUpFragment, bundle)
            }
        }

        binding.supplierLoginLayoutTextViewForgetPassword.setOnClickListener {
            findNavController().navigate(R.id.action_supplierLoginFragment_to_consumerForgotPasswordFragment)
        }

        binding.supplierLoginLayoutLoginButton.setOnClickListener {
            val email = binding.supplierLoginLayoutEditTextEmail.text.toString()
            val password = binding.supplierLoginLayoutEditTextPassword.text.toString()
            userInfo = LoginModel(email = email, password = password)
            viewModel.loginUser(userInfo)
            println(userInfo)
            viewModel.loginResponse.observe(viewLifecycleOwner) {
                if (it.data?.success == true) {
                    findNavController().navigate(R.id.action_supplierLoginFragment_to_supplier_mainActivity)
                }
            }
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
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "Please Wait", Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
