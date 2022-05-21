package com.decagon.aqua.feature.consumer.authentication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.core.data.UserRequest
import com.decagon.aqua.core.data.UserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AquaViewModel @Inject constructor(private val aquaRepository: AquaRepositoryInterface) : ViewModel() {
    private var _loginResponse: MutableLiveData<UserResponse> = MutableLiveData()
    val loginResponse: LiveData<UserResponse> = _loginResponse

    fun loginUser(email: String, password: String) {
        val userLogin = UserRequest(email, password)

        viewModelScope.launch {
            try {
                val response = aquaRepository.login(userLogin)
                _loginResponse.value = response.body()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
