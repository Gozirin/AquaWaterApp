package com.decagon.aqua.models.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.models.repository.IUpdatePasswordRepository
import com.decagon.aqua.models.updatepassword.UpdatePasswordRequest
import com.decagon.aqua.models.updatepassword.UpdatePasswordResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdatePasswordViewModel @Inject constructor
(private val updatePasswordRepository: IUpdatePasswordRepository) : ViewModel() {

    var updatePasswordLiveData: MutableLiveData<UpdatePasswordResponseModel> = MutableLiveData()
        private set

    fun updatePassword(updatePasswordRequest: UpdatePasswordRequest) {
        this.viewModelScope.launch {
            updatePasswordLiveData.value = updatePasswordRepository.updatePassword(updatePasswordRequest)
        }
    }
}
