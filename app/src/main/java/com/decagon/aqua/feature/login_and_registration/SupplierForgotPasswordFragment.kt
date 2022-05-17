package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSupplierForgotPasswordBinding

class SupplierForgotPasswordFragment : Fragment() {

    private lateinit var binding: FragmentSupplierForgotPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_supplier_forgot_password, container, false)
        return binding.rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initializing view binding
        binding = FragmentSupplierForgotPasswordBinding.bind(view)

        // navigate to consumer forgot password  page
        binding.textView3.setOnClickListener {
            findNavController().navigate(R.id.action_supplierForgotPasswordFragment_to_consumerForgotPasswordFragment)
        }
    }
}
