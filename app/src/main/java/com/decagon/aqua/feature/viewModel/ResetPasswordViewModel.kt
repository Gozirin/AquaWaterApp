package com.decagon.aqua.feature.viewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.feature.repository.IResetPasswordRepositoryInterface
import com.decagon.aqua.resetpassword.ResetPasswordRequest
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewModel @Inject constructor(private val resetPasswordRepository: IResetPasswordRepositoryInterface) : ViewModel() {

    private val _resetPasswordLiveData: MutableLiveData<ResetPasswordResponse> = MutableLiveData()
    val resetPasswordLiveData: LiveData<ResetPasswordResponse>
        get() = _resetPasswordLiveData

    fun resetPassword(resetPasswordRequest: ResetPasswordRequest) {
        viewModelScope.launch {
            try {
                val response = resetPasswordRepository.resetPassword(resetPasswordRequest)
                Log.d(TAG, "is there a response tobe observed: $response")
                _resetPasswordLiveData.value = response
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d(TAG, "here is the error: ${e.message}")
            }
        }
    }
}
