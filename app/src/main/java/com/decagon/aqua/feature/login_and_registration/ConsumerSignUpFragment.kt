package com.decagon.aqua.feature.login_and_registration

import android.app.AlertDialog
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSignUpConsumerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerSignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpConsumerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = inflater.inflate(R.layout.fragment_sign_up_consumer, container, false)
        return binding.rootView
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
        addressFocusListener()
    }

    private fun submitForm() {
        binding.emailContainer.helperText = validEmail()
        binding.phoneContainer.helperText = validPhone()
        binding.firstNameContainer.helperText = validFirstName()
        binding.lastNameContainer.helperText = validLastName()
        binding.addressContainer.helperText = validAddress()
        binding.passwordContainer.helperText = validPassword()

        val validEmail = binding.emailContainer.helperText == null
        val validFirstName = binding.firstNameContainer.helperText == null
        val validLastName = binding.lastNameContainer.helperText == null
        val validPhone = binding.phoneContainer.helperText == null
        val validPassword = binding.passwordContainer.helperText == null
        val validAddress = binding.addressContainer.helperText == null

        if (validEmail && validFirstName && validLastName && validPhone && validPassword && validAddress) {
            resetForm()
            findNavController().navigate(R.id.action_consumerSignUpFragment_to_consumer_mainActivity)
        } else
            invalidForm()
    }

    private fun invalidForm() {
        var message = ""
        message += "\n\nEmail: " + binding.emailContainer.helperText
        if (binding.phoneContainer.helperText != null)
            message += "\n\nPhone: " + binding.phoneContainer.helperText
        if (binding.passwordContainer.helperText != null)
            message += "\n\nPassword: " + binding.passwordContainer.helperText
        if (binding.firstNameContainer.helperText != null)
            message += "\n\nFirst Name: " + binding.firstNameContainer.helperText
        if (binding.lastNameContainer.helperText != null)
            message += "\n\nLast Name: " + binding.lastNameContainer.helperText
        if (binding.addressContainer.helperText != null)
            message += "\n\nAddress: " + binding.addressContainer.helperText

        AlertDialog.Builder(this.requireContext())
            .setTitle("Invalid form")
            .setMessage(message)
            .setPositiveButton("Okay") { _, _ ->
                // do nothing
            }
            .show()
    }

    private fun resetForm() {

        var message = "Email: " + binding.etEmailConsumerSignUp.text
        message += "\nPhone: " + binding.etPhoneConsumerSignUp.text
        message += "\nPassword: " + binding.etPasswordConsumerSignUp.text
        message += "\nFirst Name: " + binding.etFirstNameConsumerSignUp.text
        message += "\nLast Name: " + binding.etLastNameConsumerSignUp.text
        message += "\nAddress: " + binding.etAddressConsumerSignUp.text

        AlertDialog.Builder(this.requireContext())
            .setTitle("Form submitted")
            .setMessage(message)
            .setPositiveButton("Okay") { _, _ ->
                binding.etEmailConsumerSignUp.text = null
                binding.etPhoneConsumerSignUp.text = null
                binding.etPasswordConsumerSignUp.text = null
                binding.etFirstNameConsumerSignUp.text = null
                binding.etLastNameConsumerSignUp.text = null
                binding.etAddressConsumerSignUp.text = null

                binding.emailContainer.helperText = getString(R.string.required)
                binding.phoneContainer.helperText = getString(R.string.required)
                binding.passwordContainer.helperText = getString(R.string.required)
                binding.firstNameContainer.helperText = getString(R.string.required)
                binding.lastNameContainer.helperText = getString(R.string.required)
                binding.addressContainer.helperText = getString(R.string.required)
            }
            .show()
    }

    private fun emailFocusListener() {
        binding.etEmailConsumerSignUp.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.etEmailConsumerSignUp.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Invalid Email Address"
        }
        return null
    }

    private fun passWordFocusListener() {
        binding.etPasswordConsumerSignUp.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.passwordContainer.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val passwordText = binding.etPasswordConsumerSignUp.text.toString()
        if (passwordText.length < 8) {
            return "Minimum 8 Characters Password"
        }
        return null
    }

    private fun phoneFocusListener() {
        binding.etPhoneConsumerSignUp.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.phoneContainer.helperText = validPhone()
            }
        }
    }

    private fun validPhone(): String? {
        val phoneText = binding.etPhoneConsumerSignUp.text.toString().trim()
        if (phoneText.length != 11) {
            return "Invalid Phone Number"
        }
        return null
    }

    private fun firstNameFocusListener() {
        binding.etFirstNameConsumerSignUp.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.firstNameContainer.helperText = validFirstName()
            }
        }
    }

    private fun validFirstName(): String? {
        val firstText = binding.etFirstNameConsumerSignUp.text.toString().trim()
        if (firstText.contains(".*[0-9].*".toRegex())) {
            return "Invalid name"
        }
        if (firstText.contains(".*[!@#$%^&*()_+.,/'].*".toRegex())) {
            return "Invalid name"
        }
        return null
    }

    private fun lastNameFocusListener() {
        binding.etLastNameConsumerSignUp.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.lastNameContainer.helperText = validLastName()
            }
        }
    }

    private fun validLastName(): String? {
        val lastText = binding.etLastNameConsumerSignUp.text.toString().trim()
        if (lastText.contains(".*[0-9].*".toRegex())) {
            return "Invalid name"
        }
        if (lastText.contains(".*[!@#$%^&*()_+.,/'].*".toRegex())) {
            return "Invalid name"
        }
        return null
    }

    private fun addressFocusListener() {
        binding.etAddressConsumerSignUp.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.addressContainer.helperText = validAddress()
            }
        }
    }

    private fun validAddress(): String? {
        val addressText = binding.etLastNameConsumerSignUp.text.toString().trim()
        if (addressText.isEmpty()) {
            return "Input address"
        }
        return null
    }
}
