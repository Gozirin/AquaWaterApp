package com.decagon.aqua.feature.supplier.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FilterModalLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterModal : BottomSheetDialogFragment() {

    private lateinit var binding: FilterModalLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.filter_modal_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FilterModalLayoutBinding.bind(view)

//        binding.filterModalLO.setOnClickListener {
//            Toast.makeText(requireContext(), "Name Clicked", Toast.LENGTH_LONG).show()
//        }
//        binding.filterModalDate.setOnClickListener {
//            Toast.makeText(requireContext(), "Date Clicked", Toast.LENGTH_LONG).show()
//        }
//        binding.filterModalTimeLo.setOnClickListener {
//            Toast.makeText(requireContext(), "Time Clicked", Toast.LENGTH_LONG).show()
//        }
//        binding.filterModalItemsLo.setOnClickListener {
//            Toast.makeText(requireContext(), "Items Clicked", Toast.LENGTH_LONG).show()
//        }
//        binding.filterModalPriceLo.setOnClickListener {
//            Toast.makeText(requireContext(), "Price Clicked", Toast.LENGTH_LONG).show()
//        }
//        binding.filterModalLocationLo.setOnClickListener {
//            Toast.makeText(requireContext(), "Location Clicked", Toast.LENGTH_LONG).show()
//        }
//        binding.filterDetailModalProfileDetailClose.setOnClickListener {
//            dismiss()
//        }
    }
}
