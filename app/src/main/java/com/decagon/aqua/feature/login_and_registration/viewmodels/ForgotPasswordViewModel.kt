package com.decagon.aqua.feature.login_and_registration.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.models.ForgotPasswordRequest
import com.decagon.aqua.models.ForgotPasswordResponse
import com.decagon.aqua.repositories.IForgotPasswordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(private val forgotPasswordRepository: IForgotPasswordRepository) : ViewModel() {

    private val TAG = "FORGOT_PASSWORD"

    private val _forgotPasswordLiveData: MutableLiveData<Response<ForgotPasswordResponse>> = MutableLiveData()
    val forgotPasswordLiveData: LiveData<Response<ForgotPasswordResponse>>
        get() = _forgotPasswordLiveData

    fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest) {
        viewModelScope.launch {
            try {
                val response = forgotPasswordRepository.forgotPassword(forgotPasswordRequest)
                _forgotPasswordLiveData.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
