package com.decagon.aqua.feature.supplier.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
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
        binding.supplierAccountFragmentLogoutTv.setOnClickListener {
            val logoutDialogLayout = LayoutInflater.from(requireContext())
                .inflate(R.layout.logout_confirmation_dialog, null)
            val alertBuilder = AlertDialog.Builder(requireContext())
                .setView(logoutDialogLayout)
            val showDialog = alertBuilder.show()

            val logoutConfirmationDialogYesBtn: Button? =
                logoutDialogLayout.findViewById(R.id.logout_confirmation_dialog_log_out_yes_btn)
            logoutConfirmationDialogYesBtn?.setOnClickListener {
                findNavController().navigate(R.id.action_loggingFragment_to_supplierLoginFragment)
                showDialog.dismiss()
                // findNavController().navigate(R.id.action_logoutConfirmationDialog_to_app_nav_graph)
            }
            val logoutConfirmationDialogNoBtn: Button? =
                logoutDialogLayout.findViewById(R.id.logout_confirmation_dialog_log_out_no_btn)
            logoutConfirmationDialogNoBtn?.setOnClickListener {
                showDialog.dismiss()
            }
        }
    }
}
