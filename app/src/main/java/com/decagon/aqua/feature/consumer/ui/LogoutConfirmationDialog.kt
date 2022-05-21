package com.decagon.aqua.feature.consumer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.decagon.aqua.R
import com.decagon.aqua.databinding.LogoutConfirmationDialogBinding

class LogoutConfirmationDialog : Fragment() {
    private lateinit var binding: LogoutConfirmationDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.logout_confirmation_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LogoutConfirmationDialogBinding.bind(view)
        binding.logoutConfirmationDialogLogOutYesBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Yes Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
