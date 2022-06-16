package com.decagon.aqua.feature.login_and_registration.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.commons.Resource
import com.decagon.aqua.models.ProductByCompanyID
import com.decagon.aqua.repositories.AuthRepositoryInterface
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductByCompanyIDViewModel @Inject constructor(private val repo: AuthRepositoryInterface) : ViewModel() {
    private var _products: MutableLiveData<Resource<ProductByCompanyID>> = MutableLiveData()
    val products: LiveData<Resource<ProductByCompanyID>> = _products
    fun getCompaniesWithProducts() {
        viewModelScope.launch {
            // val response = repo.getCompaniesProducts()
            //   _products.value = response
        }
    }
}
