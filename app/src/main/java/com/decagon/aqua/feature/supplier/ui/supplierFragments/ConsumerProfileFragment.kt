package com.decagon.aqua.feature.supplier.ui.supplierFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.decagon.aqua.R
import com.decagon.aqua.databinding.ConsumerProfileDetailsBottomSheetLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerProfileFragment : BottomSheetDialogFragment() {

    private lateinit var binding: ConsumerProfileDetailsBottomSheetLayoutBinding
    private lateinit var close: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.consumer_profile_details_bottom_sheet_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ConsumerProfileDetailsBottomSheetLayoutBinding.bind(view)
    }
}
