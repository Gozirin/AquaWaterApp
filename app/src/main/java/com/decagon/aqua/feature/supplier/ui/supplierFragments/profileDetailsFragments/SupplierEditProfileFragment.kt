package com.decagon.aqua.feature.supplier.ui.supplierFragments.profileDetailsFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decagon.aqua.databinding.FragmentSupplierEditProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SupplierEditProfileFragment : Fragment() {

    private lateinit var binding: FragmentSupplierEditProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSupplierEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
}
