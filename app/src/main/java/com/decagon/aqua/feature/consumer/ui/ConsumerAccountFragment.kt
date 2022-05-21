package com.decagon.aqua.feature.consumer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.ConsumerAccountFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerAccountFragment : Fragment() {

    private lateinit var binding: ConsumerAccountFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ConsumerAccountFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.consumerAccountFragmentEditProfileTv.setOnClickListener {
            findNavController().navigate(R.id.action_consumerAccountFragment_to_consumerProfileSettingsAccountFragment)
        }

        binding.consumerAccountFragmentLogoutTv.setOnClickListener {
            val logoutDialogLayout = LayoutInflater.from(context)
                .inflate(R.layout.logout_confirmation_dialog, null)
            val alertBuilder = AlertDialog.Builder(requireContext())
                .setView(logoutDialogLayout)
            val showDialog = alertBuilder.show()
            val setReminder: Button? =
                logoutDialogLayout.findViewById(R.id.logout_confirmation_dialog_log_out_yes_btn)
            setReminder?.setOnClickListener {
                showDialog.dismiss()
                findNavController().navigate(R.id.action_logoutConfirmationDialog_to_app_nav_graph)
            }
            val logoutConfirmationDialogNoBtn: Button? =
                logoutDialogLayout.findViewById(R.id.logout_confirmation_dialog_log_out_no_btn)
            logoutConfirmationDialogNoBtn?.setOnClickListener {
                showDialog.dismiss()
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }
}
