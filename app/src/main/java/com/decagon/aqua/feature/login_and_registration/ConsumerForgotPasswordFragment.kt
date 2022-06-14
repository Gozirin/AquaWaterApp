package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerForgotPasswordBinding
import com.decagon.aqua.feature.login_and_registration.viewmodels.ForgotPasswordViewModel
import com.decagon.aqua.models.ForgotPasswordRequest
import com.decagon.aqua.validations.InputValidations
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerForgotPasswordFragment : Fragment() {
    /**
     * declare variable and views
     */
    private val TAG = "ConsumerForgotPasswordFragment"
    private lateinit var binding: FragmentConsumerForgotPasswordBinding
    private val forgotPasswordViewModel: ForgotPasswordViewModel by viewModels()
    private val args by navArgs<ConsumerForgotPasswordFragmentArgs>()

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
        binding.forgotPasswordTextInputLayout5.helperText = ""

        binding.apply {

            forgotPasswordButton1.setOnClickListener {
                val userEmail = forgotPasswordEditTextInputLayout5.text.toString()
                if (!InputValidations.validateEmailInput(userEmail))
                    Toast.makeText(requireContext(), "Enter Valid Email", Toast.LENGTH_SHORT).show()
                else {
                    forgotPasswordViewModel.forgotPassword(ForgotPasswordRequest(userEmail))
                }
            }

            /**
             * add Text changed listener
             */
            forgotPasswordEditTextInputLayout5.addTextChangedListener {
                val enteredUserEmail = forgotPasswordEditTextInputLayout5.text.toString()
                onEmailTextChanged(enteredUserEmail)
            }
        }
        binding.forgotPasswordButton1.setOnClickListener {
            findNavController().navigate(R.id.action_consumerForgotPasswordFragment_to_consumerCheckMailFragment)
        }

        // navigate to consumer check mail page
        observeForgotPasswordResponse()
    }

    private fun observeForgotPasswordResponse() {

        forgotPasswordViewModel.forgotPasswordLiveData.observe(
            viewLifecycleOwner,
            Observer {
                if (it.isSuccessful) {
                    Toast.makeText(
                        requireContext(),
                        "Request Successful",
                        Toast.LENGTH_SHORT
                    ).show()
                    findNavController().navigate(R.id.action_consumerForgotPasswordFragment_to_consumerCheckMailFragment)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "${it.errorBody()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )
    }

    private fun onEmailTextChanged(receivedEmail: String) {
        if (InputValidations.validateEmail(receivedEmail) == "Enter a valid Email Address") {
            binding.forgotPasswordTextInputLayout5.helperText = "Enter a valid Email Address"
        } else if (InputValidations.validateEmail(receivedEmail) == "Invalid Email Address") {
            binding.forgotPasswordTextInputLayout5.helperText = "Invalid Email Address"
        } else {
            binding.forgotPasswordTextInputLayout5.helperText = ""
        }
    }
}
