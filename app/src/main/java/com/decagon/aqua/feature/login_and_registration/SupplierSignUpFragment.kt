package com.decagon.aqua.feature.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentSupplierSignUpBinding
import com.decagon.aqua.models.LocationX
import com.decagon.aqua.models.UserX
import com.decagon.aqua.validations.SupplierRegistration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SupplierSignUpFragment : Fragment() {

    private var _binding: FragmentSupplierSignUpBinding? = null
    private val binding get() = _binding!!
    val function = SupplierRegistration
    private lateinit var userInfo: UserX

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSupplierSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dropDown()
        binding.supplierSignupLayoutTextViewSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_supplierSignUpFragment_to_supplierLoginFragment)
        }
        binding.supplierSignupLayoutTextViewBack.setOnClickListener {
            findNavController().navigate(R.id.action_supplierSignUpFragment_to_supplierLoginFragment)
        }

        binding.supplierSignupBtn.setEnabled(false)
        binding.supplierSignupBtn.setOnClickListener {
            binding.supplierSignupBtn.text = "Registering"
            binding.supplierRegistrationProgressBar.visibility = View.VISIBLE
            val firstName = binding.etFirstNameSupplierSignUp.text.toString()
            val lastName = binding.etLastNameSupplierSignUp.text.toString()
            val age = binding.etAgeSupplierSignUp.text.toString().toInt()
            val gender = binding.sexAutoTextView.text.toString()
            val email = binding.etEmailSupplierSignUp.text.toString()
            val password = binding.etPasswordSupplierSignUp.text.toString()
            val confrimPassword = binding.etConfirmPasswordSupplierSignUp.toString()
            val phoneNumber = binding.etPhoneSupplierSignUp.text.toString()
            userInfo = UserX(
                age, confrimPassword, email, firstName, gender, lastName,
                location = LocationX(
                    "", "", "", "", "", "", "", ""
                ),
                password, phoneNumber, profilePictureUrl = ""
            )

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
//            if (!function.validateSexInput(gender)) {
//                binding.genderError.visibility = View.VISIBLE
//                binding.supplierSignupBtn.setEnabled(true)
//                binding.supplierSignupBtn.text = "Register"
//                binding.fragmentRegisterProgressBarPb.visibility = View.GONE
//            }
//            if (function.validateSexInput(gender)) {
//                binding.genderError.visibility = View.GONE
//            }
            if (!function.validatePasswordInput(password)) {
                binding.etPasswordSupplierSignUp.error = "At least 1 uppercase, 1 lowercase, 1 special character 1 digit and at least 8 characters"
                binding.supplierSignupBtn.setEnabled(true)
                binding.supplierSignupBtn.text = "Register"
                binding.supplierRegistrationProgressBar.visibility = View.GONE
            }
            if (!function.validateConfirmPassword(password, confrimPassword)) {
                binding.etConfirmPasswordSupplierSignUp.error = "Password doesn't match"
                binding.supplierSignupBtn.setEnabled(true)
                binding.supplierSignupBtn.text = "Register"
                binding.supplierRegistrationProgressBar.visibility = View.GONE
            }
            if (function.validateFirstNameInput(firstName) &&
                function.validateLastNameInput(lastName) &&
                function.validateEmailInput(email) &&
                function.validatePasswordInput(password) &&
                function.validatePhoneInput(phoneNumber)
//                function.validateSexInput(gender)
            ) {
                binding.supplierSignupBtn.setEnabled(true)
            }
//            {
//                viewModel.addUser(userInfo)
//                viewModel.addUserResponse.observe(viewLifecycleOwner) {
//                    if (it.statusCode == 201) {
//                        binding.fragmentRegisterProgressBarPb.visibility = View.GONE
//                        binding.radioButtonMustBeCheckedErr.visibility = View.GONE
//                        val action =
//                            RegisterFragmentDirections.actionRegisterFragmentToPendingConfirmation(
//                                email
//                            )
//                        findNavController().navigate(action)
//                        binding.fragmentRegisterPhoneNumberEtv.text?.clear()
//                        binding.tvEmailText.text?.clear()
//                        binding.btnRegister.text = "Register"
//                        binding.tvConfirmPasswordResetPassword.text?.clear()
//                        binding.fragmentRegisterFirstNameEtv.text?.clear()
//                        binding.fragmentRegisterLastNameEtv.text?.clear()
//                        binding.fragmentRegisterUserNameEtv.text?.clear()
//                        binding.RegisterTickButton.isChecked = false
//                    } else {
//                        binding.btnRegister.setEnabled(true)
//                        binding.btnRegister.text = "Register"
//                        binding.radioButtonMustBeCheckedErr.visibility = View.GONE
//                        binding.fragmentRegisterProgressBarPb.visibility = View.GONE
//                        Snackbar.make(view, it.message, Snackbar.LENGTH_SHORT).show()
//                    }
//                }
//            }
        }
    }
    private fun dropDown() {
        val gender = resources.getStringArray(R.array.gender)
        val adapter = ArrayAdapter(requireContext(), R.layout.gender_list, gender)
        with(binding.sexAutoTextView) {
            setAdapter(adapter)
        }
    }
}
