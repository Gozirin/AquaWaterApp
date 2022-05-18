package com.decagon.aqua.feature.supplier.ui.supplierFragments.profileDetailsFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decagon.aqua.databinding.FragmentSupplierAddProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SupplierAddProductFragment : Fragment() {

    private lateinit var binding: FragmentSupplierAddProductBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSupplierAddProductBinding.inflate(inflater, container, false)
        return binding.root
    }
}
