package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSignUpConsumerBinding
import com.decagon.aqua.feature.consumer.validation.* // ktlint-disable no-wildcard-imports
import com.decagon.aqua.feature.login_and_registration.viewmodels.AuthenticationViewModel
import com.decagon.aqua.models.Consumer
import com.decagon.aqua.models.Location
import com.decagon.aqua.models.consumerAuthModule.User
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "TAG"
@AndroidEntryPoint
class ConsumerSignUpFragment : Fragment() {

    private var _binding: FragmentSignUpConsumerBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthenticationViewModel by viewModels()
    private lateinit var firstName: String
    private lateinit var lastName: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var street: String
    private lateinit var city: String
    private lateinit var state: String
    private lateinit var phoneNumber: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentSignUpConsumerBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        firstName = binding.etFirstNameConsumerSignUp.text.toString()
        lastName = binding.etLastNameConsumerSignUp.text.toString()
        email = binding.etEmailConsumerSignUp.text.toString()
        phoneNumber = binding.etPhoneConsumerSignUp.text.toString()
        state = binding.etStateConsumerSignUp.text.toString()
        street = binding.etStreetConsumerSignUp.text.toString()
        city = binding.etCityConsumerSignUp.text.toString()
        password = binding.etPasswordConsumerSignUp.text.toString()

        binding.emailContainer.helperText = validateEmailInput(email)
        binding.phoneContainer.helperText = validatePhoneInput(phoneNumber)
        binding.firstNameContainer.helperText = validateFirstNameInput(firstName)
        binding.lastNameContainer.helperText = validateLastNameInput(lastName)
        binding.stateContainer.helperText = validateStreet(state)
        binding.streetContainer.helperText = validateStreet(street)
        binding.cityContainer.helperText = validateCity(city)
        binding.passwordContainer.helperText = validatePasswordInput(password)

        val validEmail = binding.emailContainer.helperText == null
        val validFirstName = binding.firstNameContainer.helperText == null
        val validLastName = binding.lastNameContainer.helperText == null
        val validPhone = binding.phoneContainer.helperText == null
        val validPassword = binding.passwordContainer.helperText == null
        val validState = binding.stateContainer.helperText == null
        val validCity = binding.cityContainer.helperText == null
        val validStreet = binding.streetContainer.helperText == null

        val location = Location(city = city, state = state, street = street)
        val signUpRequest = User(
            firstName = firstName, lastName = lastName, email = email, confirmPassword = password,
            phoneNumber = phoneNumber, password = password, location = location, age = 34, gender = "Male"
        )

        val signUpConsumer = Consumer(user = signUpRequest)

        if (validEmail && validFirstName && validLastName && validPhone && validPassword && validState && validCity && validStreet) {

            viewModel.signUp(signUpConsumer)
            Log.d(TAG, "submitForm: $signUpRequest")
        }
        viewModel.signUp.observe(viewLifecycleOwner) {
            if (it.data?.success == true) {
                Log.d(TAG, "submitFormrResponse: ${it.message}, ${it.data}")
                Snackbar.make(requireView(), "Consumer successfully created!", Snackbar.LENGTH_LONG).setAnchorView(binding.consumerSignupLayoutButtonSignIn).show()
                Log.d(TAG, "submitForm: ${it.data.message}")
                findNavController().navigate(R.id.action_consumerSignUpFragment_to_consumerCheckMailFragment)
            } else {
                Snackbar.make(requireView(), it.message.toString(), Snackbar.LENGTH_LONG).setAnchorView(binding.consumerSignupLayoutButtonSignIn).show()
                Log.d(TAG, "submitForm: ${it.message}")
            }
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
