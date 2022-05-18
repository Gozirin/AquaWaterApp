package com.decagon.aqua.feature.supplier.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSupplierAccountLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SupplierAccountPage : Fragment() {

    private lateinit var binding: FragmentSupplierAccountLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSupplierAccountLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.supplierAccountFragmentEditProfileTv.setOnClickListener {
            findNavController().navigate(R.id.action_supplierAccountPage_to_supplierProfileDetailsFragment)
        }
    }
}
