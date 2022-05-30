package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSignUpConsumerBinding
import com.decagon.aqua.feature.consumer.validation.* // ktlint-disable no-wildcard-imports
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerSignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpConsumerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSignUpConsumerBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpConsumerBinding.bind(view)
        val nextbtn = binding.consumerSignupLayoutTextViewSignIn
        nextbtn.setOnClickListener {
            findNavController().navigate(R.id.action_consumerSignUpFragment_to_loginFragment)
        }

        binding.consumerSignupLayoutTextViewBack.setOnClickListener {
            findNavController().navigate(R.id.action_consumerSignUpFragment_to_loginFragment)
        }
        binding.consumerSignupLayoutButtonSignIn.setOnClickListener {
            submitForm()
        }
        emailFocusListener()
        passWordFocusListener()
        phoneFocusListener()
        firstNameFocusListener()
        lastNameFocusListener()
        stateFocusListener()
        streetFocusListener()
        cityFocusListener()
    }

    private fun submitForm() {
        binding.emailContainer.helperText = validateEmailInput(binding.etEmailConsumerSignUp.text.toString())
        binding.phoneContainer.helperText = validatePhoneInput(binding.etPhoneConsumerSignUp.text.toString())
        binding.firstNameContainer.helperText = validateFirstNameInput(binding.etFirstNameConsumerSignUp.text.toString())
        binding.lastNameContainer.helperText = validateFirstNameInput(binding.etLastNameConsumerSignUp.text.toString())
        binding.stateContainer.helperText = validateStreet(binding.etStateConsumerSignUp.text.toString())
        binding.streetContainer.helperText = validateStreet(binding.etStreetConsumerSignUp.text.toString())
        binding.cityContainer.helperText = validateCity(binding.etCityConsumerSignUp.text.toString())
        binding.passwordContainer.helperText = validatePasswordInput(binding.etPasswordConsumerSignUp.text.toString())

        val validEmail = binding.emailContainer.helperText == null
        val validFirstName = binding.firstNameContainer.helperText == null
        val validLastName = binding.lastNameContainer.helperText == null
        val validPhone = binding.phoneContainer.helperText == null
        val validPassword = binding.passwordContainer.helperText == null
        val validState = binding.stateContainer.helperText == null
        val validCity = binding.cityContainer.helperText == null
        val validStreet = binding.streetContainer.helperText == null

        if (validEmail && validFirstName && validLastName && validPhone && validPassword && validState && validCity && validStreet) {
            findNavController().navigate(R.id.action_consumerSignUpFragment_to_consumer_mainActivity)
        }
    }

    private fun emailFocusListener() {
        binding.etEmailConsumerSignUp.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.emailContainer.helperText = validateEmailInput(binding.etEmailConsumerSignUp.text.toString())
            }
        }
    }

    private fun passWordFocusListener() {
        binding.etPasswordConsumerSignUp.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.passwordContainer.helperText = validatePasswordInput(binding.etPasswordConsumerSignUp.text.toString())
            }
        }
    }

    private fun phoneFocusListener() {
        binding.etPhoneConsumerSignUp.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.phoneContainer.helperText = validatePhoneInput(binding.etPhoneConsumerSignUp.text.toString())
            }
        }
    }

    private fun firstNameFocusListener() {
        binding.etFirstNameConsumerSignUp.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.firstNameContainer.helperText = validateFirstNameInput(binding.etFirstNameConsumerSignUp.text.toString())
            }
        }
    }

    private fun lastNameFocusListener() {
        binding.etLastNameConsumerSignUp.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.lastNameContainer.helperText = validateLastNameInput(binding.etLastNameConsumerSignUp.text.toString())
            }
        }
    }

    private fun stateFocusListener() {
        binding.etStateConsumerSignUp.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.stateContainer.helperText = validateState(binding.etStateConsumerSignUp.text.toString())
            }
        }
    }

    private fun cityFocusListener() {
        binding.etCityConsumerSignUp.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.cityContainer.helperText = validateState(binding.etCityConsumerSignUp.text.toString())
            }
        }
    }

    private fun streetFocusListener() {
        binding.etStreetConsumerSignUp.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.streetContainer.helperText = validateState(binding.etStreetConsumerSignUp.text.toString())
            }
        }
    }
}
