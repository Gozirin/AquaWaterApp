package com.decagon.aqua.feature.login_and_registration

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerForgotPasswordBinding
import com.decagon.aqua.feature.viewModel.ResetPasswordViewModel
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerForgotPasswordFragment : Fragment() {
    private val TAG = "ConsumerForgotPasswordFragment"
    private lateinit var binding: FragmentConsumerForgotPasswordBinding
    private val resetPasswordViewModel: ResetPasswordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_consumer_forgot_password, container, false)
        return binding.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initializing view binding
        binding = FragmentConsumerForgotPasswordBinding.bind(view)

        binding.apply {
            val email = forgotPasswordTextInputLayout5.editText.toString()
            val token = forgotPasswordTextInputLayout5.editText.toString()

            val resetPasswordRequest = ResetPasswordRequest(email, token)

            forgotPasswordButton1.setOnClickListener {
                resetPasswordViewModel.resetPassword(resetPasswordRequest)
            }
        }

        // Back button to return to Login page
        binding.forgotPasswordImageButton1.setOnClickListener {
            findNavController().navigate(R.id.action_consumerForgotPasswordFragment_to_loginFragment)
        }
        // navigate to consumer check mail page
        observeResetPasswordResponse()
    }
    @SuppressLint("FragmentLiveDataObserve")
    private fun observeResetPasswordResponse() {
        resetPasswordViewModel.resetPasswordLiveData.observe(this,) {
            Log.d(TAG, "observeResetPasswordResponse: ")
            Toast.makeText(requireContext(), "resetPassword Successful", Toast.LENGTH_SHORT).show()
        }
    }
}
