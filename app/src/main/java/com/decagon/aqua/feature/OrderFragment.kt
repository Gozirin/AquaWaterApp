package com.example.tablayout.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decagon.aqua.R
import com.example.tablayout.* // ktlint-disable no-wildcard-imports
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class OrderFragment : BottomSheetDialogFragment(), SupplierAdapter.OnItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SupplierOrderHistoryAdapter(SupplierOrderHistoryRvItem().supplierOrderList)
        val rvOrderView = view.findViewById<RecyclerView>(R.id.consumer_order_history_reclyclerView)
        rvOrderView?.adapter = adapter
        rvOrderView?.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onItemClick(position: Int) {
        val filterModalBottomSheet = OrderDetails()
        val filter_tv = view?.findViewById<Button>(R.id.consumer_order_detail_modal__button)
        filter_tv?.setOnClickListener {
            val supportFragmentManager = parentFragmentManager
            filterModalBottomSheet.show(supportFragmentManager, "TAG")
        }
    }
}
