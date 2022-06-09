package com.decagon.aqua.feature.consumer.ui.consumptionFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerChangePasswordScreenBinding
import com.decagon.aqua.models.inputvalidation.Inputvalidation
import com.decagon.aqua.models.updatepassword.UpdatePasswordModel
import com.decagon.aqua.models.viewmodel.UpdatePasswordViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

private const val AUTH_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjlhMjRhZjA0LTg2Y2MtNGZiMC1hZTY2LTk5OWNiYTE2YmQ2OCIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2VtYWlsYWRkcmVzcyI6ImdvemllYW55YXNvOEBnbWFpbC5jb20iLCJGaXJzdE5hbWUiOiJQcmVjaW91cyIsIkxhc3ROYW1lIjoiQW55YXNvIiwiZXhwIjoxNjU0Njk5ODI1LCJpc3MiOiJ3d3cuc2VjdXJpdHkub3JnIiwiYXVkIjoid3d3LnNlY3VyaXR5Lm9yZyJ9.ajFbgdTk_IDglACnvUTSgnEY9NZXftz5_1wk4cs-5L0"
private val TAG = "TAG"
@AndroidEntryPoint
class ConsumerChangePasswordScreenFragment : Fragment() {

    private lateinit var binding: FragmentConsumerChangePasswordScreenBinding
    private val updatePasswordModel: UpdatePasswordViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate these layout for the fragment
        super.onCreate(savedInstanceState)
        val binding =
            inflater.inflate(R.layout.fragment_consumer_change_password_screen, container, false)
        return binding.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentConsumerChangePasswordScreenBinding.bind(view)


        binding.apply {

            changePasswordScreenButton.setOnClickListener {
                val newPassword = textInputLayout2.editText?.text.toString()
                val confirmPassword = textInputLayout4.editText?.text.toString()
                val currentPassword = changePasswordScreenTextInputLayout1.editText?.text.toString()

                if (!Inputvalidation.validateNewPassword(newPassword) || !Inputvalidation.validateConfirmPassword(
                        newPassword,
                        confirmPassword
                    ) || !Inputvalidation.validateNewPassword(currentPassword)
                ) {
                    Toast.makeText(requireContext(), "Enter Valid Password", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val updatePassword =
                        UpdatePasswordModel(
                            newPassword,
                            confirmPassword,
                            email = "gozieanyaso8@gmail.com",
                            currentPassword
                        )
                    Log.d(TAG, "updatePassword: $updatePassword ")

                    updatePasswordModel.updatePassword(AUTH_TOKEN, updatePassword)
                }

            }
        }

        /**
         * add a textchangeListener to input fields
         */
        binding.currentPasswordEditText.addTextChangedListener {
            val currentPassword = binding.currentPasswordEditText.text.toString()
            onCurrentPasswordTextChange(currentPassword)
        }

        binding.newPasswordEditText.addTextChangedListener {
            val newPassword = binding.newPasswordEditText.text.toString()
            onNewPasswordTextChange(newPassword)
        }

        binding.confirmPasswordEditText.addTextChangedListener {
            val newPassword = binding.newPasswordEditText.text.toString()
            val confirmPassword = binding.confirmPasswordEditText.text.toString()
            onConfirmPasswordTextChange(newPassword, confirmPassword)
        }


        /**
         * observe the response from the update password
         */
        updatePasswordModel.updatePasswordLiveData.observe(viewLifecycleOwner) { updatePasswordResponse ->
            if (updatePasswordResponse.success) {
                Snackbar.make(requireView(), updatePasswordResponse.Message, Snackbar.LENGTH_LONG)
                    .setAnchorView(binding.changePasswordScreenButton).show()
            } else {
                Snackbar.make(
                    requireView(),
                    updatePasswordResponse.errors.toString(),
                    Snackbar.LENGTH_LONG
                ).setAnchorView(binding.changePasswordScreenButton).show()
            }
        }
    }

    fun onCurrentPasswordTextChange(currentPassword: String) {
        if (Inputvalidation.validatePasswordEntered(currentPassword) == "Password cannot be empty") {
            binding.changePasswordScreenTextInputLayout1.helperText = "Password cannot be empty"
        } else if (Inputvalidation.validatePasswordEntered(currentPassword) == "Password must have a minimum of 8 characters.") {
            binding.changePasswordScreenTextInputLayout1.helperText =
                "Password must have a minimum of 8 characters."
        } else if (Inputvalidation.validatePasswordEntered(currentPassword) == "Password must contain at least 1 number.") {
            binding.changePasswordScreenTextInputLayout1.helperText =
                "Password must contain at least 1 number."
        } else if (Inputvalidation.validatePasswordEntered(currentPassword) == "Password must contain at least 1 upper case character.") {
            binding.changePasswordScreenTextInputLayout1.helperText =
                "Password must contain at least 1 upper case character."
        } else if (Inputvalidation.validatePasswordEntered(currentPassword) == "Password must contain at least 1 lower case character.") {
            binding.changePasswordScreenTextInputLayout1.helperText =
                "Password must contain at least 1 lower case character."
        } else if (Inputvalidation.validatePasswordEntered(currentPassword) == "Password must contain at least 1 special character (@#$%&?!).") {
            binding.changePasswordScreenTextInputLayout1.helperText =
                "Password must contain at least 1 special character (@#$%&?!)."
        } else {
            binding.changePasswordScreenTextInputLayout1.helperText = ""
        }
    }

    fun onNewPasswordTextChange(newPassword: String) {
        if (Inputvalidation.validatePasswordEntered(newPassword) == "Password cannot be empty") {
            binding.textInputLayout2.helperText = "Password cannot be empty"
        } else if (Inputvalidation.validatePasswordEntered(newPassword) == "Password must have a minimum of 8 characters.") {
            binding.textInputLayout2.helperText = "Password must have a minimum of 8 characters."
        } else if (Inputvalidation.validatePasswordEntered(newPassword) == "Password must contain at least 1 number.") {
            binding.textInputLayout2.helperText = "Password must contain at least 1 number."
        } else if (Inputvalidation.validatePasswordEntered(newPassword) == "Password must contain at least 1 upper case character.") {
            binding.textInputLayout2.helperText =
                "Password must contain at least 1 upper case character."
        } else if (Inputvalidation.validatePasswordEntered(newPassword) == "Password must contain at least 1 lower case character.") {
            binding.textInputLayout2.helperText =
                "Password must contain at least 1 lower case character."
        } else if (Inputvalidation.validatePasswordEntered(newPassword) == "Password must contain at least 1 special character (@#$%&?!).") {
            binding.textInputLayout2.helperText =
                "Password must contain at least 1 special character (@#$%&?!)."
        } else {
            binding.textInputLayout2.helperText = ""
        }
    }

    fun onConfirmPasswordTextChange(password: String, confirmPassword: String) {
        if (!Inputvalidation.validateConfirmPassword(password, confirmPassword)) {
            binding.textInputLayout4.helperText = "Invalid Password Entered"
        } else {
            binding.textInputLayout4.helperText = ""
        }
    }

}



































