package com.decagon.aqua.feature.supplier.ui.supplierFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentTotalSuppliesMadeSupplierBinding
import com.decagon.aqua.feature.supplier.adapter.SupplierDataListItems
import com.decagon.aqua.feature.supplier.adapter.SupplierRVAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PastSuppliesFragment : Fragment(), SupplierRVAdapter.OnItemClickListener {

    private lateinit var binding: FragmentTotalSuppliesMadeSupplierBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_supplies_made__supplier, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTotalSuppliesMadeSupplierBinding.bind(view)

        /**
         * to call the filter modal bottomsheet
         */
        // val filterModalBottomSheet = FilterModal()
//        binding.totalSupplyMadeSupplierFilterTv.setOnClickListener {
//            Toast.makeText(requireContext(), "Display Filter Modal", Toast.LENGTH_SHORT).show()
//        }
        /**
         * Back textview on top of TotalSuppliesMade(past supplies) screen
         */
        binding.totalSupplyMadeSupplierBackTv.setOnClickListener {
            findNavController().navigate(R.id.action_pastSuppilesFragement_to_supplierHomePage)
        }

        /**
         * LayoutManager and adapter for recyclerview on
         * TotalSuppliesMade(past supplies) screen
         */
        binding.totalSupplyMadeSupplierPastSuppliesRV.layoutManager = LinearLayoutManager(requireContext())
        binding.totalSupplyMadeSupplierPastSuppliesRV
            .adapter = SupplierRVAdapter(SupplierDataListItems().supplierList, this)
    }

    /**
     * OnClickListener for recyclerview on TotalSuppliesMade(past supplies) screen
     */
    override fun OnItemClick(position: Int) {
        val consumer_modal_sheet =
            BottomSheetDialog(requireContext(), R.style.bottom_sheet_dialog_theme)
        val bottomSheetView = LayoutInflater.from(requireContext()).inflate(
            R.layout.consumer_profile_details_bottom_sheet_layout,
            LinearLayout(context)
        )
        /**
         * To display the consumer_profile_detail_bottom_sheet_layout that rises up
         * when recyclerview item on TotalSuppliesMade(past supplies) screen is clicked
         */
        consumer_modal_sheet.setContentView(bottomSheetView)
        consumer_modal_sheet.show()
    }
}
