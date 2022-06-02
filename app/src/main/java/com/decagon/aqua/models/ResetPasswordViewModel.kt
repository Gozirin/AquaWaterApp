package com.decagon.aqua.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.feature.repository.IResetPasswordRepositoryInterface
import com.decagon.aqua.models.ResetPasswordRequest
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewModel @Inject constructor(private val resetPasswordRepository: IResetPasswordRepositoryInterface) : ViewModel() {

    var resetPasswordLiveData: MutableLiveData<ResetPasswordResponse> = MutableLiveData()
        private set

    fun resetPassword(resetPasswordRequest: ResetPasswordRequest) {
        viewModelScope.launch {
            resetPasswordLiveData.value = resetPasswordRepository.resetPassword(resetPasswordRequest)
        }
    }
}
