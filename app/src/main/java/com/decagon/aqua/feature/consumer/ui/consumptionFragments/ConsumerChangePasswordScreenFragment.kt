package com.decagon.aqua.feature.consumer.ui.consumptionFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.decagon.aqua.R
import com.decagon.aqua.databinding.FragmentConsumerChangePasswordScreenBinding
import com.decagon.aqua.models.updatepassword.UpdatePasswordRequest
import com.decagon.aqua.models.viewmodel.UpdatePasswordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsumerChangePasswordScreenFragment : Fragment() {
    private val TAG = "ConsumerChangePasswordScreenFragment"
    private lateinit var binding: FragmentConsumerChangePasswordScreenBinding
    private val updatePasswordModel: UpdatePasswordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val binding =
            inflater.inflate(R.layout.fragment_consumer_change_password_screen, container, false)
        return binding.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentConsumerChangePasswordScreenBinding.bind(view)
        Log.d(TAG, "onViewCreated: ")
        binding.apply {
            val CurrentPassword = changePasswordScreenTextInputLayout1.editText.toString()
            val NewPassword = textInputLayout2.editText.toString()
            val ConfirmPassword = textInputLayout4.editText.toString()
            val updatePassword =
                UpdatePasswordRequest(CurrentPassword, NewPassword, ConfirmPassword)

            binding.changePasswordScreenButton.setOnClickListener {
                updatePasswordModel.updatePassword(updatePassword)
            }
        }
    }
}

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
