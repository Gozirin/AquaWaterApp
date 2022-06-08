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
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerCreateNewPasswordBinding
import com.decagon.aqua.feature.authentication.InputValidation
import com.decagon.aqua.feature.authentication.InputValidation.validateNewPassword
import com.decagon.aqua.feature.authentication.InputValidation.validateNewPasswordAndConfirmPassword
import com.decagon.aqua.feature.authentication.InputValidation.validateNotEmptyNewPasswordField
import com.decagon.aqua.feature.viewModel.ResetPasswordViewModel
import com.decagon.aqua.resetpassword.ResetPasswordRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerCreateNewPasswordFragment : Fragment() {
    private val TAG = "ConsumerCreateNewPasswordFragment"
    private lateinit var binding: FragmentConsumerCreateNewPasswordBinding
    private lateinit var  validPassword: String
//    private val args by navArgs<ConsumerCreateNewPasswordFragmentArgs>()
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

        Log.d(TAG, " email, token")

        // Don't have account signup to page.
        binding.createNewTextView6.setOnClickListener {
            findNavController().navigate(R.id.action_consumerCreateNewPasswordFragment_to_supplierSignUpFragment)
        }

        // navigate to password account successful
        binding.createNewButton2.setOnClickListener {
            findNavController().navigate(R.id.action_consumerCreateNewPasswordFragment_to_password_AccountSuccessfulFragment2)
        }
        binding.apply {

            createNewButton2.setOnClickListener {

                validPassword = binding.textInputLayout.toString()
                val newPassword = binding.textInputLayoutEditTextNewPassword.text.toString()
                if (InputValidation.validatePassword(validPassword) == null)
                else{
                    Log.d(TAG, "observeForgotPasswordResponse")
                }

                val confirmPassword = binding.textInputLayoutEditTextConfirmPassword.text.toString()
                if (InputValidation.validatePassword(validPassword) == null)

                else {
                    resetPasswordViewModel.resetPassword(
                        ResetPasswordRequest(

                            newPassword,
                            confirmPassword
                        )
                    )
                }

            }
            textInputLayoutEditTextNewPassword.addTextChangedListener {
                validPassword = textInputLayoutEditTextNewPassword.text.toString()
                onPasswordTextChanged(validPassword)
            }
            textInputLayoutEditTextConfirmPassword.addTextChangedListener {
                validPassword = textInputLayoutEditTextConfirmPassword.text.toString()
                onPasswordTextChanged(validPassword)
            }
            val newPassword = binding.textInputLayoutEditTextNewPassword.text.toString()
            val confirmPassword = binding.textInputLayoutEditTextConfirmPassword.text.toString()

            if (validateNotEmptyNewPasswordField(newPassword) &&
                validateNewPassword(newPassword) &&
                validateNewPasswordAndConfirmPassword(newPassword, confirmPassword)

            ) {
//                binding.fragmentResetPasswordProgressBarPb.visibility = View.VISIBLE
                binding.textInputLayout.visibility = View.VISIBLE
                binding.createNewButton2.text = "Reset Password"

            } else {

                if (InputValidation.validatePassword(newPassword) == null) {
                    binding.textInputLayout.helperText = "Please enter your new password"
                    binding.textInputLayout.visibility = View.VISIBLE

                }
                if (InputValidation.validatePassword(confirmPassword) == null) {
                    binding.textInputLayout.helperText = "Please enter valid password"
                }

                if  (validateNewPassword(newPassword) && !validateNewPasswordAndConfirmPassword(
                        newPassword,
                        confirmPassword
                    )
                ) {
                    binding.textInputLayout3.helperText = "Password does not match"
                    binding.textInputLayout3.visibility = View.VISIBLE
                }
            }
            observeForgotPasswordResponse()
        }

    }

    private fun observeForgotPasswordResponse() {

        resetPasswordViewModel.resetPasswordLiveData.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "observeForgotPasswordResponse: ${it.message} ")
            Toast.makeText(requireContext(), "ForgotPassword Successful", Toast.LENGTH_SHORT).show()
        })
    }

    private fun onPasswordTextChanged(received_Password: String) {
        binding.textInputLayout.helperText = InputValidation.validatePassword(received_Password)
        binding.textInputLayout3.helperText =  InputValidation.validatePassword(received_Password)
    }

}

