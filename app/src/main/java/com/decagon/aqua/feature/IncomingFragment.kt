package com.example.tablayout.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentIncomingBinding
import com.example.tablayout.SupplierAdapter
import com.example.tablayout.SupplierRvItem
import com.google.android.material.bottomsheet.BottomSheetDialog

class IncomingFragment : Fragment(), SupplierAdapter.OnItemClickListener {

    private lateinit var binding: FragmentIncomingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_incoming, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentIncomingBinding.bind(view)

        val adapter = SupplierAdapter(SupplierRvItem().supplierList, this)
        val rView = view?.findViewById<RecyclerView>(R.id.consumer_incoming_order_modal_recyclerView)
        rView?.adapter = adapter
        rView?.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onItemClick(position: Int) {

        val orderBottomSheet = BottomSheetDialog(requireContext(), R.style.bottom_sheet_dialog_theme)
        val bottomSheetView = LayoutInflater.from(requireContext()).inflate(
            R.layout.fragment_order, LinearLayout(context)
        )

        orderBottomSheet.setContentView(bottomSheetView)
        orderBottomSheet.show()
    }
}
