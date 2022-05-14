package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSupplierSignUpBinding

class SupplierSignUpFragment : Fragment() {
    private var _binding: FragmentSupplierSignUpBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSupplierSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.supplierSignupTextViewSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_supplierSignUpFragment_to_supplierLoginFragment)
        }
        binding.supplierSignupTextViewBack.setOnClickListener {
            findNavController().navigate(R.id.action_supplierSignUpFragment_to_supplierLoginFragment)
        }
    }
}
