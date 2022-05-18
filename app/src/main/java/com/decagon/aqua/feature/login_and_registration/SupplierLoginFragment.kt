package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSupplierLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SupplierLoginFragment : Fragment() {
    private lateinit var binding: FragmentSupplierLoginBinding
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
        // navigate to signup page
        binding.supplierLoginSignup.setOnClickListener {
            findNavController().navigate(R.id.action_supplierLoginFragment_to_supplierSignUpFragment)
        }
        // navigate to supplier forgot password page
        binding.supplierLoginLayoutTextViewForgetPassword.setOnClickListener {
            findNavController().navigate(R.id.action_supplierLoginFragment_to_supplierForgotPasswordFragment)
        }
        binding.supplierLoginLayoutLoginButton.setOnClickListener {
            findNavController().navigate(R.id.action_supplierLoginFragment_to_supplier_mainActivity)
        }
    }
}
