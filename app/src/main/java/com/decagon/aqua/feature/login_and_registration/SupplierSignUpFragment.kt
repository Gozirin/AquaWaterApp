package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.decagon.aqua.R
import com.decagon.aqua.commons.ConnectivityLiveData
import com.decagon.aqua.commons.Resource
import com.decagon.aqua.databinding.FragmentSupplierSignUpBinding
import com.decagon.aqua.feature.login_and_registration.viewmodels.AuthenticationViewModel
import com.decagon.aqua.models.LocationX
import com.decagon.aqua.models.Supplier
import com.decagon.aqua.models.supplierAuthModule.CompanyList
import com.decagon.aqua.models.supplierAuthModule.UserX
import com.decagon.aqua.validations.SupplierRegistration
import com.decagon.aqua.validations.SupplierRegistration.validateAgeInput
import com.decagon.aqua.validations.SupplierRegistration.validateCompanySelection
import com.decagon.aqua.validations.SupplierRegistration.validateConfirmPassword
import com.decagon.aqua.validations.SupplierRegistration.validateEmailInput
import com.decagon.aqua.validations.SupplierRegistration.validateFirstNameInput
import com.decagon.aqua.validations.SupplierRegistration.validateLastNameInput
import com.decagon.aqua.validations.SupplierRegistration.validatePasswordInput
import com.decagon.aqua.validations.SupplierRegistration.validatePhoneInput
import com.decagon.aqua.validations.SupplierRegistration.validateSex
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SupplierSignUpFragment : Fragment() {

    private var _binding: FragmentSupplierSignUpBinding? = null
    private val binding get() = _binding!!
    private val function = SupplierRegistration
    private val viewModel: AuthenticationViewModel by viewModels()
    private lateinit var connectivityLiveData: ConnectivityLiveData
    private lateinit var userInfo: Supplier
    private val companies = hashMapOf<String, String>()
    private val Errors = mutableSetOf<TextInputLayout>()
    private val args: SupplierSignUpFragmentArgs by navArgs()
    lateinit var list: CompanyList

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSupplierSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectivityLiveData = ConnectivityLiveData(requireActivity().application)
        checkNetworkStatus()
        genderDropDown()
        bindUI()
        populateCompanyDropDown()
    }

    private fun populateCompanyDropDown() {
        list = args.list
        list.data.map { company ->
            companies.put(company.companyName, company.id)
        }
        val xyz = companies.keys.toTypedArray()
        val adapter = ArrayAdapter(requireContext(), R.layout.company_list, xyz)
        with(binding.companyAutoTextView) {
            setAdapter(adapter)
        }
        binding.companyAutoTextView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, _, position, _ ->
                binding.etCompanyId.setText(companies.getValue(parent?.getItemAtPosition(position).toString()))
            }
    }

    private fun bindUI() {
        binding.supplierSignupLayoutTextViewSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_supplierSignUpFragment_to_supplierLoginFragment)
        }
        binding.supplierSignupLayoutTextViewBack.setOnClickListener {
            findNavController().navigate(R.id.action_supplierSignUpFragment_to_supplierLoginFragment)
        }

        binding.supplierSignupBtn.setOnClickListener {
            clearErrors()
            binding.supplierSignupBtn.isEnabled = false
            binding.supplierRegistrationProgressBar.visibility = View.VISIBLE
            val firstName = binding.etFirstNameSupplierSignUp.text.toString()
            val lastName = binding.etLastNameSupplierSignUp.text.toString()
            val age = if (binding.etAgeSupplierSignUp.text.toString().isBlank())
                0 else binding.etAgeSupplierSignUp.text.toString().toInt()
            val gender = binding.sexAutoTextView.text.toString()
            val email = binding.etEmailSupplierSignUp.text.toString()
            val companyName = binding.companyAutoTextView.text.toString()
            val companyId = binding.etCompanyId.text.toString()
            val street = binding.supplierStreetEditText?.text.toString()
            val city = binding.supplierCityEditText?.text.toString()
            val state = binding.supplierStateEditText?.text.toString()
            val password = binding.etPasswordSupplierSignUp.text.toString()
            val confirmPassword = binding.etConfirmPasswordSupplierSignUp.text.toString()
            val phoneNumber = binding.etPhoneSupplierSignUp.text.toString()
            userInfo = Supplier(
                companyId,
                user = UserX(
                    age, confirmPassword, email, firstName, gender, lastName,
                    location = LocationX(
                        city, "", "", "", "", "", state, street
                    ),
                    password, phoneNumber, profilePictureUrl = ""
                )

            )
            Log.d("check", "onViewCreated: $userInfo ")

            if (!validateCompanySelection(companyId)) {
                setError(
                    binding.supplierCompanyContainer,
                    "Select a company"
                )
                showSignUpButton()
            }
            if (!validateFirstNameInput(firstName)) {
                setError(
                    binding.supplierFirstNameContainer,
                    "Should start with a capital letter, at least 3 character"
                )
                showSignUpButton()
            }
            if (!validateLastNameInput(lastName)) {
                setError(
                    binding.supplierLastNameContainer,
                    "Should start with a capital letter, at least 3 character"
                )
                showSignUpButton()
            }
            if (validateAgeInput(age) != 0) {
                if (validateAgeInput(age) == 1)
                    setError(binding.supplierAgeContainer, "age field is required")
                else if (validateAgeInput(age) == 2) // gives more detail reason for error
                    setError(
                        binding.supplierAgeContainer,
                        "you are too young to register"
                    ) // edit this later
                else if (validateAgeInput(age) == 3)
                    setError(binding.supplierAgeContainer, "enter a valid age")
                showSignUpButton()
            }
            if (!validateEmailInput(email)) {
                setError(binding.supplierEmailContainer, "Invalid email")
                showSignUpButton()
            }
            if (!validatePhoneInput(phoneNumber)) {
                setError(
                    binding.supplierPhoneContainer,
                    "Starts with '0' followed by '7', '8' or '9' and 11 characters"
                )
                showSignUpButton()
            }
            if (!validateSex(gender)) {
                setError(binding.supplierGenderContainer, "Gender must be male or female")
                showSignUpButton()
            }
            if (!validatePasswordInput(password)) {
                setError(
                    binding.supplierPasswordContainer,
                    "At least 1 uppercase, 1 lowercase, 1 special character 1 digit and at least 8 characters"
                )
                showSignUpButton()
            }
            if (!validateConfirmPassword(password, confirmPassword)) {
                setError(binding.supplierConfirmPasswordContainer, "Password doesn't match")
                showSignUpButton()
            }
            if (!validateCompanySelection(street)) {
                setError(
                    binding.supplierStreetContainer!!,
                    "Street is required"
                )
                showSignUpButton()
            }
            if (!validateCompanySelection(city)) {
                setError(
                    binding.supplierCityContainer!!,
                    "City is required"
                )
                showSignUpButton()
            }
            if (!validateCompanySelection(state)) {
                setError(
                    binding.supplierStateContainer!!,
                    "State is required"
                )
                showSignUpButton()
            }
            if (validateCompanySelection(companyId) &&
                validateFirstNameInput(firstName) &&
                validateLastNameInput(lastName) &&
                validateAgeInput(age) == 0 &&
                validateEmailInput(email) &&
                validatePasswordInput(password) &&
                validatePhoneInput(phoneNumber) &&
                validateSex(gender) &&
                validateCompanySelection(street) &&
                validateCompanySelection(city) &&
                validateCompanySelection(state)
            ) {
                viewModel.registerSupplier(userInfo)
                viewModel.registerResponse.observe(requireActivity()) {
                    when (it) {
                        is Resource.Success -> {
                            Snackbar.make(view!!, it.data?.message.toString(), Snackbar.LENGTH_LONG).setAnchorView(binding.supplierSignupBtn).show()
                            binding.supplierRegistrationProgressBar.visibility = View.GONE
                            findNavController().navigate(R.id.action_supplierSignUpFragment_to_consumerCheckMailFragment)
                            binding.etFirstNameSupplierSignUp.text?.clear()
                            binding.etLastNameSupplierSignUp.text?.clear()
                            binding.supplierSignupBtn.text = "Register"
                            binding.etPasswordSupplierSignUp.text?.clear()
                            binding.etConfirmPasswordSupplierSignUp.text?.clear()
                            binding.etPhoneSupplierSignUp.text?.clear()
                            binding.etAgeSupplierSignUp.text?.clear()
                            binding.etEmailSupplierSignUp.text?.clear()
                            binding.supplierStreetEditText?.text?.clear()
                            binding.supplierCityEditText?.text?.clear()
                            binding.supplierStateEditText?.text?.clear()
                        }
                        is Resource.Error -> {
                            Snackbar.make(view!!, it.message.toString(), Snackbar.LENGTH_LONG).setAnchorView(binding.supplierSignupBtn).show()
                            binding.supplierSignupBtn.isEnabled = true
                            binding.supplierRegistrationProgressBar.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }

    private fun genderDropDown() {
        val gender = resources.getStringArray(R.array.gender)
        val adapter = ArrayAdapter(requireContext(), R.layout.gender_list, gender)
        with(binding.sexAutoTextView) {
            setAdapter(adapter)
        }
    }

    private fun checkNetworkStatus() {
        connectivityLiveData.observe(
            viewLifecycleOwner,
            Observer { isAvailable ->
                when (isAvailable) {
                    false -> {
                        binding.NetworkErrorMsg?.visibility = View.VISIBLE
                        binding.signFragmentLayout?.visibility = View.INVISIBLE
                    }
                    true -> {
                        binding.NetworkErrorMsg?.visibility = View.GONE
                        binding.signFragmentLayout?.visibility = View.VISIBLE
                    }
                }
            }
        )
    }

    private fun showSignUpButton() {
        binding.supplierSignupBtn.isEnabled = true
        binding.supplierSignupBtn.text = "Register"
        binding.supplierRegistrationProgressBar.visibility = View.GONE
    }

    private fun clearErrors() {
        if (Errors.isEmpty()) return
        for (err in Errors) {
            err.error = null
        }
    }

    private fun setError(view: TextInputLayout, errorMessage: String) {
        view.error = "* $errorMessage"
        Errors.add(view)
    }
}
