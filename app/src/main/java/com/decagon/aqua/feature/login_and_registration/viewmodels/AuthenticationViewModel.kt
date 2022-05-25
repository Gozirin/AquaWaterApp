package com.decagon.aqua.feature.login_and_registration.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.models.Supplier
import com.decagon.aqua.models.supplierAuthModule.RegisterResponse
import com.decagon.aqua.repositories.AuthRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(private val authRepository: AuthRepositoryInterface) : ViewModel() {

    private val _registerResponse: MutableLiveData<RegisterResponse> = MutableLiveData()
    val registerResponse: LiveData<RegisterResponse> = _registerResponse

    fun registerSupplier(supplier: Supplier) {
        viewModelScope.launch {
            val response = authRepository.addSupplier(supplier)
            if (response.isSuccessful) {
                _registerResponse.value = response.body()
            }
        }
    }
}
