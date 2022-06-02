package com.decagon.aqua.feature.consumer.authentication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.commons.util.Resource
import com.decagon.aqua.core.data.UserLoginRequest
import com.decagon.aqua.core.data.UserLoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AquaViewModel @Inject constructor(private val aquaRepositoryInt: AquaRepositoryInterface) : ViewModel() {

    var loginLiveData: MutableLiveData<Resource<UserLoginResponse>> = MutableLiveData()
        private set

    fun loginUser(userLoginRequest: UserLoginRequest) {
        viewModelScope.launch {
            loginLiveData.value = aquaRepositoryInt.login(userLoginRequest)
        }
    }
}
