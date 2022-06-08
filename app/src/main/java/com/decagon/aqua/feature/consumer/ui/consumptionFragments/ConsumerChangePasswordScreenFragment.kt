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
import com.decagon.aqua.models.inputvalidation.Inputvalidation.validateCurrentPasswordAndOldPasswordAndConfirmPassword
import com.decagon.aqua.models.inputvalidation.Inputvalidation.validateNewPassword
import com.decagon.aqua.models.inputvalidation.Inputvalidation.validateNotEmptyNewPasswordField
import com.decagon.aqua.models.updatepassword.UpdatePasswordModel
import com.decagon.aqua.models.updatepassword.UpdatePasswordRequest
import com.decagon.aqua.models.viewmodel.UpdatePasswordViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

private const val AUTH_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjlhMjRhZjA0LTg2Y2MtNGZiMC1hZTY2LTk5OWNiYTE2YmQ2OCIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL2VtYWlsYWRkcmVzcyI6ImdvemllYW55YXNvOEBnbWFpbC5jb20iLCJGaXJzdE5hbWUiOiJQcmVjaW91cyIsIkxhc3ROYW1lIjoiQW55YXNvIiwiZXhwIjoxNjU0Njk5ODI1LCJpc3MiOiJ3d3cuc2VjdXJpdHkub3JnIiwiYXVkIjoid3d3LnNlY3VyaXR5Lm9yZyJ9.ajFbgdTk_IDglACnvUTSgnEY9NZXftz5_1wk4cs-5L0"
private val TAG = "TAG"
@AndroidEntryPoint
class ConsumerChangePasswordScreenFragment : Fragment() {

    private lateinit var binding: FragmentConsumerChangePasswordScreenBinding
    private val updatePasswordModel: UpdatePasswordViewModel by viewModels()
    private lateinit var validPassword: String
    private val updatePasswordViewModel: UpdatePasswordViewModel by viewModels()

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
        binding.changePasswordScreenTextInputLayout1.helperText =""
        binding.textInputLayout2.helperText =""
        binding.textInputLayout4.helperText =""

        binding.apply {

            changePasswordScreenButton.setOnClickListener {
                val newPassword = textInputLayout2.editText?.text.toString()
                val confirmPassword = textInputLayout4.editText?.text.toString()
                val currentPassword = changePasswordScreenTextInputLayout1.editText?.text.toString()

                if (!Inputvalidation.validateNewPassword(newPassword)  || !Inputvalidation.validateConfirmPassword(newPassword, confirmPassword)) {
                        Toast.makeText(requireContext(), "Enter Valid Password", Toast.LENGTH_SHORT).show()
                } else {
                    val updatePassword =
                        UpdatePasswordModel(newPassword, confirmPassword, email = "gozieanyaso8@gmail.com", currentPassword)
                    Log.d(TAG, "updatePassword: $updatePassword ")

                    updatePasswordModel.updatePassword(AUTH_TOKEN, updatePassword)
                }

            }
        }

        /**
         * add a textchangeListener
         */


        /**
         * observe the response from the update password
         */
        updatePasswordModel.updatePasswordLiveData.observe(viewLifecycleOwner) { updatePasswordResponse ->
            if (updatePasswordResponse.success) {
                Snackbar.make(requireView(), updatePasswordResponse.Message, Snackbar.LENGTH_LONG).setAnchorView(binding.changePasswordScreenButton).show()
            } else {
                Snackbar.make(requireView(), updatePasswordResponse.errors.toString(), Snackbar.LENGTH_LONG).setAnchorView(binding.changePasswordScreenButton).show()
            }
        }
    }
    private fun onUpdateTextChanged(savedPassword: String) {

//        binding.changePasswordScreenTextInputLayout1.helperText = Inputvalidation.validateNewPassword(savedPassword)
//        binding.textInputLayout2.helperText = Inputvalidation.validatePassword(saved_Password)
//        binding.textInputLayout4.helperText = Inputvalidation.validatePassword(saved_Password)
    }
}
















        //        binding.apply {
//                changePasswordScreenButton.setOnClickListener {
//                    validPassword = binding.changePasswordScreenTextInputLayout1.toString()
//                    val currentPassword =
//                        binding.currentPasswordEditText.text.toString()
//                    if (Inputvalidation.validatePassword(validPassword) == null)
//                    else {
//                        Toast.makeText(requireContext(), "Enter Valid Password", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//
//                    val newPassword = binding.newPasswordEditText.text.toString()
//                    if (Inputvalidation.validatePassword(validPassword) != null)
//                    else {
//                        Toast.makeText(requireContext(), "Enter Valid Password", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//
//                    val confirmPassword =
//                        binding.confirmPasswordEditText.text.toString()
//                    if (Inputvalidation.validatePassword(validPassword) != null)
//
//                    else {
////
////                        updatePasswordViewModel.updatePassword(
////                            AUTH_TOKEN(
////                                currentPassword,
////                                newPassword,
////                                confirmPassword
////                            )
////                        )
//                    }
//                }
//                currentPasswordEditText.addTextChangedListener {
//                    validPassword = currentPasswordEditText.text.toString()
//                    onUpdateTextChanged(validPassword)
//                }
//
//                newPasswordEditText.addTextChangedListener {
//                    validPassword = newPasswordEditText.text.toString()
//                    onUpdateTextChanged(validPassword)
//                }
//
//                confirmPasswordEditText.addTextChangedListener {
//                    validPassword = confirmPasswordEditText.text.toString()
//                    onUpdateTextChanged(validPassword)
//                }
//                val currentPassword = binding.changePasswordScreenTextInputLayout1.helperText.toString()
//                val newPassword = binding.textInputLayout4.helperText.toString()
//                val confirmPassword = binding.textInputLayout2.helperText.toString()
//
//                if (validateNotEmptyNewPasswordField(newPassword) &&
//                    validateNewPassword(newPassword) &&
//                    validateCurrentPasswordAndOldPasswordAndConfirmPassword(currentPassword, newPassword, confirmPassword)
//
//                ) {
////                binding.fragmentUpdatePasswordProgressBarPb.visibility = View.VISIBLE
//                    binding.textInputLayout2.visibility = View.VISIBLE
//                    binding.changePasswordScreenButton.text = "Reset Password"
//                } else {
//                    if(Inputvalidation.validatePassword(currentPassword)==null){
//                        binding.changePasswordScreenTextInputLayout1.helperText = "Please enter your current password"
//                        binding.changePasswordScreenTextInputLayout1.visibility = View.VISIBLE
//                    }
//
//                    if (Inputvalidation.validatePassword(newPassword) == null) {
//                        binding.textInputLayout2.helperText = "Please enter your new password"
//                        binding.textInputLayout2.visibility = View.VISIBLE
//                    }
//                    if (Inputvalidation.validatePassword(confirmPassword) == null) {
//                        binding.textInputLayout4.helperText = "Please enter valid password"
//                    }
//
//                    if (validateNewPassword(newPassword) && !validateCurrentPasswordAndOldPasswordAndConfirmPassword(
//                            newPassword,
//                            confirmPassword,
//                            confirmPassword
//                        )
//                    ) {
//                        binding.textInputLayout4.helperText = "Password does not match"
//                        binding.textInputLayout4.visibility = View.VISIBLE
//                    }
//                }
//            }
//        }

        /**
         * observe the response from the update password
         */
/*
        updatePasswordModel.updatePasswordLiveData.observe(viewLifecycleOwner) { updatePasswordResponse ->
            if (updatePasswordResponse.success) {
                Snackbar.make(requireView(), updatePasswordResponse.Message, Snackbar.LENGTH_LONG).setAnchorView(binding.changePasswordScreenButton).show()
            } else {
                Snackbar.make(requireView(), updatePasswordResponse.errors.toString(), Snackbar.LENGTH_LONG).setAnchorView(binding.changePasswordScreenButton).show()
            }
        }
    }
    private fun onUpdateTextChanged(saved_Password: String) {
        binding.changePasswordScreenTextInputLayout1.helperText = Inputvalidation.validatePassword(saved_Password)
        binding.textInputLayout2.helperText = Inputvalidation.validatePassword(saved_Password)
        binding.textInputLayout4.helperText = Inputvalidation.validatePassword(saved_Password)
    }
}

 */



















//
// private fun makeCompanyListCall() {
//    viewModel.getCompanies()
//    viewModel.companyList.observe(requireActivity()) { it: Resource<CompanyList>!
//            when (it) {
//                is Resource.Success -> {
//                    bundle = Bundle().apply { this: Bundle
//                    putSerializable("list",it.data)}
//                }
//            }
//
//    }
// }
//
//

//        binding.apply { //FragmentConsumerChangePasswordScreenBinding }
//            val CurrentPassword = changePasswordScreenTextInputLayout1.toString(),
//            val NewPassword = textInputLayout2.toString()
//            val ConfirmPassword = textInputLayout4.toString()
//            val updatePasswordRequest =
//                UpdatePasswordRequest(CurrentPassword, NewPassword, ConfirmPassword)
//
//            changePasswordScreenButton.setOnClickListener { it: view! }
//            updatePasswordViewModel.update(updatePasswordRequest)
//
//        }
//    }
//
//    observeUpdatePasswordResponse()
// }
//
//    private fun observeUpdatePasswordResponse() {
//        UpdatePasswordViewModel.UpdatePasswordLiveData.observe( owner: this)
//        val updatePasswordResponse = { it: updatePassword!
//            Log.d(ConsumerChangePasswordScreenFragment.toString(),"observeUpdatePasswordResponse:$it")
//            Toast.makeText(this, "$it",Toast.LENGTH_SHORT).show()
//        }
//
//    }
