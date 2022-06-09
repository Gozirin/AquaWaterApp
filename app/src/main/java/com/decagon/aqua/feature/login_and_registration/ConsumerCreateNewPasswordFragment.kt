package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerCreateNewPasswordBinding
import com.decagon.aqua.feature.authentication.InputValidation
import com.decagon.aqua.feature.authentication.InputValidation.validateNewPassword
import com.decagon.aqua.feature.authentication.InputValidation.validateNewPasswordAndConfirmPassword
import com.decagon.aqua.feature.viewModel.ResetPasswordViewModel
import com.decagon.aqua.resetpassword.ResetPasswordRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerCreateNewPasswordFragment : Fragment() {
    private val TAG = "ConsumerCreateNewPasswordFragment"
    private lateinit var binding: FragmentConsumerCreateNewPasswordBinding
    private val args by navArgs<ConsumerCreateNewPasswordFragmentArgs>()
    private val resetPasswordViewModel: ResetPasswordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val binding = inflater.inflate(R.layout.fragment_consumer_create_new_password, container, false)
        return binding.rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initializing view binding
        binding = FragmentConsumerCreateNewPasswordBinding.bind(view)

        binding.textInputLayout.helperText = ""
        binding.textInputLayout3.helperText = ""

        // Don't have account signup to page.

        binding.apply {
            /**
             * Reset Password
             */
            resetPasswordButton.setOnClickListener {

                val newPassword = binding.textInputLayoutEditTextNewPassword.text.toString()
                val confirmPassword = binding.textInputLayoutEditTextConfirmPassword.text.toString()

                if ((InputValidation.validatePassword(newPassword)) == null) {
                    Toast.makeText(requireContext(), "New Password Valid", Toast.LENGTH_SHORT).show()
                } else {
                    resetPasswordViewModel.resetPassword(
                        ResetPasswordRequest(
                            email = String(),
                            token = String(), newPassword, confirmPassword = String()
                        )
                    )
                }

                if (validateNewPassword(newPassword) && validateNewPasswordAndConfirmPassword(
                        newPassword,
                        confirmPassword
                    )
                ) {
                    Log.d(TAG, "message: $newPassword, $confirmPassword")
                } else {
                    binding.textInputLayout.helperText = "Please enter your new password"
                    binding.textInputLayout.visibility = View.VISIBLE
                    binding.textInputLayout3.helperText = "Password does not match"
                    binding.textInputLayout3.visibility = View.VISIBLE
                    Log.d(TAG, "message:$newPassword, $confirmPassword, ${it.id} ")
                }
            }

            /**
             * using the text-watcher
             */
            binding.textInputLayoutEditTextNewPassword.addTextChangedListener {
                val newPassword = textInputLayoutEditTextNewPassword.text.toString()
                binding.textInputLayoutEditTextNewPassword.text.toString()
                onPasswordTextChanged(newPassword)
            }

            binding.textInputLayoutEditTextConfirmPassword.addTextChangedListener {
                val confirmPassword = textInputLayoutEditTextConfirmPassword.text.toString()
                binding.textInputLayoutEditTextConfirmPassword.text.toString()
                onPasswordTextChanged(confirmPassword)
            }
        }
        observeForgotPasswordResponse()
    }
    private fun onPasswordTextChanged(receivedPassword: String) {
        binding.textInputLayout.helperText = InputValidation.validatePassword(receivedPassword)
        binding.textInputLayout3.helperText = InputValidation.validatePassword(receivedPassword)
    }

    private fun observeForgotPasswordResponse() {

        resetPasswordViewModel.resetPasswordLiveData.observe(
            viewLifecycleOwner,
            Observer {
                Log.d(TAG, "observeForgotPasswordResponse: ${it.message} ")
                if (it.success) {
                    Toast.makeText(requireContext(), "password successful", Toast.LENGTH_SHORT).show()
                    // findNavController().navigate(R.id.action_consumerCreateNewPasswordFragment_to_supplierLoginFragment)
                }
            }
        )
    }
}
