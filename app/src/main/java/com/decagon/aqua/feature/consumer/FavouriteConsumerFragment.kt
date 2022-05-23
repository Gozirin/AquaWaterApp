package com.example.sprint2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentFavouriteConsumerBinding
import com.decagon.aqua.feature.consumer.adapters.ConsumerModalAdapter
import com.decagon.aqua.feature.supplier.adapter.ConsumerModalItem
import com.google.android.material.bottomsheet.BottomSheetDialog

class FavouriteConsumerFragment : Fragment(), ConsumerModalAdapter.OnItemClickListener {
    private lateinit var binding: FragmentFavouriteConsumerBinding

    private lateinit var dialog: BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_favourite_consumer, container, false)
        return binding.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouriteConsumerBinding
            .bind(view)
        dialog = BottomSheetDialog(requireContext(), R.style.bottom_sheet_dialog_theme)

        // displaying the recyclerView?/
        val adapter = ConsumerModalAdapter(ConsumerModalItem().consumerModalItem, this)
        // val adapter = ModalAdapter(ConsumerModalItem().consumerModalItem, this)
        binding.consumerModalRecyclerView.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        dialog = BottomSheetDialog(requireContext(), R.style.bottom_sheet_dialog_theme)
        val productsDetailsDialogue: View = layoutInflater.inflate(
            R.layout.fragment_consumer_modal, view?.findViewById(R.id.consumer_modal_bottomSheet) as LinearLayout?
        )

        // displaying bottomSheet fragment
        val setReminder: Button? = productsDetailsDialogue.findViewById(R.id.consumer_modal_button)
        setReminder?.setOnClickListener {
            Toast.makeText(requireContext(), "hide", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.consumerModal2Fragment)
        }
        showDialog(productsDetailsDialogue)
    }
    private fun showDialog(view: View) {
        dialog.setContentView(view)
        dialog.show()
    }
}
