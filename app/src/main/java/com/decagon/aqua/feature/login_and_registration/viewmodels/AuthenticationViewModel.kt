package com.decagon.aqua.feature.login_and_registration.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.commons.Resource
import com.decagon.aqua.core.data.UserSignUpResponse
import com.decagon.aqua.models.Consumer
import com.decagon.aqua.models.Supplier
import com.decagon.aqua.models.supplierAuthModule.* // ktlint-disable no-wildcard-imports
import com.decagon.aqua.repositories.AuthRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(private val authRepository: AuthRepositoryInterface) : ViewModel() {

    // register supplier
    private val _registerResponse: MutableLiveData<Resource<RegisterResponse>> = MutableLiveData()
    val registerResponse: LiveData<Resource<RegisterResponse>> = _registerResponse

    // register consumer
    private val _signUp: MutableLiveData<Resource<UserSignUpResponse>> = MutableLiveData()
    val signUp get() = _signUp

    // login supplier
    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>> = _loginResponse

    // get companies
    private val _companyList: MutableLiveData<Resource<CompanyList>> = MutableLiveData()
    val companyList: LiveData<Resource<CompanyList>> = _companyList

    fun registerSupplier(supplier: Supplier) {
        _registerResponse.value = Resource.Loading()
        viewModelScope.launch {
            _registerResponse.value = authRepository.addSupplier(supplier)
        }
    }

    fun getCompanies() {
        _companyList.value = Resource.Loading()
        viewModelScope.launch {
            _companyList.value = authRepository.getCompanies()
        }
    }

    fun confirmEmail(confirmEmailModel: ConfirmEmailModel) {
        _registerResponse.value = Resource.Loading()
        viewModelScope.launch {
            _registerResponse.value = authRepository.confirmEmail(confirmEmailModel)
        }
    }

    fun loginUser(loginModel: LoginModel) {
        _loginResponse.value = Resource.Loading()
        viewModelScope.launch {
            _loginResponse.value = authRepository.loginUser(loginModel)
        }
    }

    fun signUp(userSignUpRequest: Consumer) {
        viewModelScope.launch {
            signUp.value = authRepository.addConsumer(userSignUpRequest)
        }
    }
}
