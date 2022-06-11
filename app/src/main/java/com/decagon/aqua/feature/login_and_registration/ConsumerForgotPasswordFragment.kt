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
import androidx.navigation.fragment.navArgs
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerForgotPasswordBinding
import com.decagon.aqua.feature.ForgotPassword.ForgotPasswordRequest
import com.decagon.aqua.feature.authentication.InputValidation
import com.decagon.aqua.feature.viewModel.ForgotPasswordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerForgotPasswordFragment : Fragment() {
    private val TAG = "ConsumerForgotPasswordFragment"
    private lateinit var validEmail: String
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
                if (InputValidation.validateEmail(validEmail) != null)
                    Toast.makeText(requireContext(), "Enter Valid Email", Toast.LENGTH_SHORT).show()
                else {
                    forgotPasswordViewModel.forgotPassword(ForgotPasswordRequest(validEmail))
                }
            }

            /**
             * add Text changed listener
             */
            forgotPasswordEditTextInputLayout5.addTextChangedListener {
                validEmail = forgotPasswordEditTextInputLayout5.text.toString()
                onEmailTextChanged(validEmail)
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
                Log.d(TAG, "observeForgotPasswordResponse: ${it.message()} ")
                if (it.isSuccessful) {
                    Toast.makeText(
                        requireContext(),
                        "ForgotPassword Successful",
                        Toast.LENGTH_SHORT
                    ).show()
                    findNavController().navigate(R.id.action_consumerForgotPasswordFragment_to_consumerCheckMailFragment)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Enter Valid Email",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )
    }

    private fun onEmailTextChanged(received_Email: String) {
        binding.forgotPasswordTextInputLayout5.helperText = InputValidation.validateEmail(received_Email)
    }
}
