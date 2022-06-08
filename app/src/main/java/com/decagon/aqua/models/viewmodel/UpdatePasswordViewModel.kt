package com.decagon.aqua.models.viewmodel

import androidx.lifecycle.*
import com.decagon.aqua.models.repository.IUpdatePasswordRepository
import com.decagon.aqua.models.updatepassword.UpdatePasswordModel
import com.decagon.aqua.models.updatepassword.UpdatePasswordResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdatePasswordViewModel @Inject constructor(
    private val updatePasswordRepository: IUpdatePasswordRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _updatePasswordLiveData: MutableLiveData<UpdatePasswordResponseModel> =
        MutableLiveData()
    val updatePasswordLiveData: LiveData<UpdatePasswordResponseModel> = _updatePasswordLiveData

    fun updatePassword(
        authToken: String,
        updatePasswordRequest: UpdatePasswordModel
    ) {
        viewModelScope.launch {
            try {
                val response =
                    updatePasswordRepository.updatePassword(authToken, updatePasswordRequest)
                _updatePasswordLiveData.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}




