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
import com.decagon.aqua.feature.login_and_registration.viewmodels.ResetPasswordViewModel
import com.decagon.aqua.models.ResetPasswordRequest
import com.decagon.aqua.validations.InputValidations
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

                if (!InputValidations.validateNewPassword(newPassword) || !InputValidations.validateConfirmPassword(newPassword, confirmPassword)) {
                    Toast.makeText(requireContext(), "Enter a valid password", Toast.LENGTH_SHORT).show()
                } else {
                    resetPasswordViewModel.resetPassword(
                        ResetPasswordRequest(
                            email = args.email.toString(),
                            token = args.token.toString(), newPassword, confirmPassword
                        )
                    )
                }
            }

            /**
             * using the text-watcher
             */
            binding.textInputLayoutEditTextNewPassword.addTextChangedListener {
                val newPassword = textInputLayoutEditTextNewPassword.text.toString()
                onNewPassword(newPassword)
            }

            binding.textInputLayoutEditTextConfirmPassword.addTextChangedListener {
                val confirmPassword = textInputLayoutEditTextConfirmPassword.text.toString()
                val newPassword = textInputLayoutEditTextNewPassword.text.toString()
                onConfirmPasswordTextChange(newPassword, confirmPassword)
            }
        }
        observeForgotPasswordResponse()
    }
    private fun onPasswordTextChanged(receivedPassword: String) {
        binding.textInputLayout.helperText = InputValidations.validatePassword(receivedPassword)
        binding.textInputLayout3.helperText = InputValidations.validatePassword(receivedPassword)
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

    private fun onNewPassword(newPassword: String) {
        if (InputValidations.validatePassword(newPassword) == "Password cannot be empty") {
            binding.textInputLayout.helperText = "Password cannot be empty"
        } else if (InputValidations.validatePassword(newPassword) == "Password must have a minimum of 8 characters.") {
            binding.textInputLayout.helperText = "Password must have a minimum of 8 characters."
        } else if (InputValidations.validatePassword(newPassword) == "Password must contain at least 1 number.") {
            binding.textInputLayout.helperText = "Password must contain at least 1 number."
        } else if (InputValidations.validatePassword(newPassword) == "Password must contain at least 1 upper case character.") {
            binding.textInputLayout.helperText = "Password must contain at least 1 upper case character."
        } else if (InputValidations.validatePassword(newPassword) == "Password must contain at least 1 lower case character.") {
            binding.textInputLayout.helperText = "Password must contain at least 1 lower case character."
        } else if (InputValidations.validatePassword(newPassword) == "Password must contain at least 1 special character (@#$%&?!).") {
            binding.textInputLayout.helperText = "Password must contain at least 1 special character (@#$%&?!)."
        } else {
            binding.textInputLayout.helperText = ""
        }
    }

    fun onConfirmPasswordTextChange(newPassword: String, confirmPassword: String) {
        if (!InputValidations.validateConfirmPassword(newPassword, confirmPassword)) {
            binding.textInputLayout3.helperText = "Invalid Password Entered"
        } else {
            binding.textInputLayout3.helperText = ""
        }
    }
}
