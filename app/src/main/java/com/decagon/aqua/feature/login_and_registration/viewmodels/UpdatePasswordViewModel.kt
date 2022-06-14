package com.decagon.aqua.feature.login_and_registration.viewmodels

import androidx.lifecycle.* // ktlint-disable no-wildcard-imports
import com.decagon.aqua.models.updatepassword.UpdatePasswordModel
import com.decagon.aqua.models.updatepassword.UpdatePasswordResponseModel
import com.decagon.aqua.repositories.IUpdatePasswordRepository
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
