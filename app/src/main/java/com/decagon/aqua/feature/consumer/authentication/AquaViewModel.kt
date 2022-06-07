package com.decagon.aqua.feature.consumer.authentication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.core.data.UserSignUpResponse
import com.decagon.aqua.models.Consumer
import com.decagon.aqua.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AquaViewModel @Inject constructor(private val aquaRepositoryInterface: AquaRepositoryInterface) : ViewModel() {

    private val _signUp: MutableLiveData<Resource<UserSignUpResponse>> = MutableLiveData()
    val signUp get() = _signUp

    fun signUp(userSignUpRequest: Consumer) {
        viewModelScope.launch {
            signUp.value = aquaRepositoryInterface.signUp(userSignUpRequest)
        }
    }
}
