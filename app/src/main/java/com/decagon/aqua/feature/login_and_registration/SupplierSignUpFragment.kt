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
import com.decagon.aqua.R
import com.decagon.aqua.commons.ConnectivityLiveData
import com.decagon.aqua.databinding.FragmentSupplierSignUpBinding
import com.decagon.aqua.feature.login_and_registration.viewmodels.AuthenticationViewModel
import com.decagon.aqua.models.LocationX
import com.decagon.aqua.models.Supplier
import com.decagon.aqua.models.supplierAuthModule.UserX
import com.decagon.aqua.validations.SupplierRegistration
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SupplierSignUpFragment : Fragment() {

    private var _binding: FragmentSupplierSignUpBinding? = null
    private val binding get() = _binding!!
    private val function = SupplierRegistration
    private val viewModel: AuthenticationViewModel by viewModels()
    private lateinit var userInfo: Supplier
    private val companies = hashMapOf<String, String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSupplierSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getCompanies = viewModel.getCompanies()
        viewModel.companyList.observe(
            viewLifecycleOwner,
            Observer { list ->
                list.data.map { company ->
                    companies.put(company.companyName, company.id)
                }
                companyDropDown()
            }
        )
        dropDown()

        binding.supplierSignupLayoutTextViewSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_supplierSignUpFragment_to_supplierLoginFragment)
        }
        binding.supplierSignupLayoutTextViewBack.setOnClickListener {
            findNavController().navigate(R.id.action_supplierSignUpFragment_to_supplierLoginFragment)
        }

        binding.supplierSignupBtn.setOnClickListener {
            binding.supplierSignupBtn.setEnabled(false)
            binding.supplierSignupBtn.text = "Registering"
            binding.supplierRegistrationProgressBar.visibility = View.VISIBLE
            val firstName = binding.etFirstNameSupplierSignUp.text.toString()
            val lastName = binding.etLastNameSupplierSignUp.text.toString()
            val age = binding.etAgeSupplierSignUp.text.toString().toInt()
            val gender = binding.sexAutoTextView.text.toString()
            val email = binding.etEmailSupplierSignUp.text.toString()
            val companyName = binding.companyAutoTextView.text.toString()
            val companyId = binding.etCompanyId.text.toString()
            val password = binding.etPasswordSupplierSignUp.text.toString()
            val confirmPassword = binding.etConfirmPasswordSupplierSignUp.text.toString()
            val phoneNumber = binding.etPhoneSupplierSignUp.text.toString()
            userInfo = Supplier(
                companyId,
                user = UserX(
                    age, confirmPassword, email, firstName, gender, lastName,
                    location = LocationX(
                        "Lagos", "Nigeria", "11", "3.60", "9.60", "nil", "Lagos", ""
                    ),
                    password, phoneNumber, profilePictureUrl = ""
                )

            )
            Log.d("check", "onViewCreated: $userInfo ")

            if (!function.validateFirstNameInput(firstName)) {
                binding.etFirstNameSupplierSignUp.error = "Should start with a capital letter, at least 3 character"
                binding.supplierSignupBtn.setEnabled(true)
                binding.supplierSignupBtn.text = "Register"
                binding.supplierRegistrationProgressBar.visibility = View.GONE
            }
            if (!function.validateLastNameInput(lastName)) {
                binding.etLastNameSupplierSignUp.error = "Atleast 1 letter, atleast 3 character"
                binding.supplierSignupBtn.setEnabled(true)
                binding.supplierSignupBtn.text = "Register"
                binding.supplierRegistrationProgressBar.visibility = View.GONE
            }
            if (!function.validateEmailInput(email)) {
                binding.etEmailSupplierSignUp.error = "Invalid email"
                binding.supplierSignupBtn.setEnabled(true)
                binding.supplierSignupBtn.text = "Register"
                binding.supplierRegistrationProgressBar.visibility = View.GONE
            }
            if (!function.validatePhoneInput(phoneNumber)) {
                binding.etPhoneSupplierSignUp.error = "Starts with '0' followed by '7', '8' or '9' and 11 characters"
                binding.supplierSignupBtn.setEnabled(true)
                binding.supplierSignupBtn.text = "Register"
                binding.supplierRegistrationProgressBar.visibility = View.GONE
            }
            if (!function.validateSex(gender)) {
                binding.genderError.visibility = View.VISIBLE
                binding.supplierSignupBtn.setEnabled(true)
                binding.supplierSignupBtn.text = "Register"
                binding.supplierRegistrationProgressBar.visibility = View.GONE
            }
            if (function.validateSex(gender)) {
                binding.genderError.visibility = View.GONE
            }
            if (!function.validatePasswordInput(password)) {
                binding.etPasswordSupplierSignUp.error = "At least 1 uppercase, 1 lowercase, 1 special character 1 digit and at least 8 characters"
                binding.supplierSignupBtn.setEnabled(true)
                binding.supplierSignupBtn.text = "Register"
                binding.supplierRegistrationProgressBar.visibility = View.GONE
            }
            if (!function.validateConfirmPassword(password, confirmPassword)) {
                binding.etConfirmPasswordSupplierSignUp.error = "Password doesn't match"
                binding.supplierSignupBtn.setEnabled(true)
                binding.supplierSignupBtn.text = "Register"
                binding.supplierRegistrationProgressBar.visibility = View.GONE
            }
            if (function.validateFirstNameInput(firstName) &&
                function.validateLastNameInput(lastName) &&
                function.validateEmailInput(email) &&
                function.validatePasswordInput(password) &&
                function.validatePhoneInput(phoneNumber) &&
                function.validateSex(gender)
            ) {
                viewModel.registerSupplier(userInfo)
                viewModel.registerResponse.observe(viewLifecycleOwner) {
                    if (it.success) {
                        binding.supplierRegistrationProgressBar.visibility = View.GONE
                        val action = SupplierSignUpFragmentDirections.actionSupplierSignUpFragmentToConsumerCheckMailFragment()
                        findNavController().navigate(action)
                        binding.etFirstNameSupplierSignUp.text?.clear()
                        binding.etLastNameSupplierSignUp.text?.clear()
                        binding.supplierSignupBtn.text = "Register"
                        binding.etPasswordSupplierSignUp.text?.clear()
                        binding.etConfirmPasswordSupplierSignUp.text?.clear()
                        binding.etPhoneSupplierSignUp.text?.clear()
                        binding.etAgeSupplierSignUp.text?.clear()
                        binding.etEmailSupplierSignUp.text?.clear()
                    } else {
                        binding.supplierSignupBtn.isEnabled = true
                        binding.supplierSignupBtn.text = "Register"
                        binding.supplierRegistrationProgressBar.visibility = View.GONE
                        Snackbar.make(view, it.message, Snackbar.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun dropDown() {
        val gender = resources.getStringArray(R.array.gender)
        val adapter = ArrayAdapter(requireContext(), R.layout.gender_list, gender)
        with(binding.sexAutoTextView) {
            setAdapter(adapter)
        }
    }

    private fun companyDropDown() {
        val xyz = companies.keys.toTypedArray()
        val adapter = ArrayAdapter(requireContext(), R.layout.company_list, xyz)
        with(binding.companyAutoTextView) {
            setAdapter(adapter)
        }
        binding.companyAutoTextView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                binding.etCompanyId.setText(companies.getValue(parent?.getItemAtPosition(position).toString()))
            }
    }
}
