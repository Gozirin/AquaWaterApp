package com.decagon.aqua.feature.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.feature.ForgotPassword.ForgotPasswordResponse
import com.decagon.aqua.feature.repository.IForgotPasswordRepository
import com.decagon.aqua.feature.ForgotPassword.ForgotPasswordRequest
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(private val forgotPasswordRepository: IForgotPasswordRepository): ViewModel(){

    private val TAG = "FORGOT_PASSWORD"

    private val _forgotPasswordLiveData: MutableLiveData<Response<ForgotPasswordResponse>> = MutableLiveData()
    val forgotPasswordLiveData: LiveData<Response<ForgotPasswordResponse>>
        get() = _forgotPasswordLiveData

    fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest){
        viewModelScope.launch {
            try {
                val response = forgotPasswordRepository.forgotPassword(forgotPasswordRequest)
                Log.d(TAG, "is there a response tobe observed: ${response}")
                _forgotPasswordLiveData.value = response
            } catch (e:Exception){
                e.printStackTrace()
                Log.d(TAG, "here is the error: ${e.message}")
            }
        }
    }

}