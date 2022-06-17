package com.decagon.aqua.feature.login_and_registration.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.commons.Resource
import com.decagon.aqua.models.companyProductmodel.CompanyProductResponse
import com.decagon.aqua.repositories.companyproductrepository.ICompanyProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductByCompanyIDViewModel @Inject constructor(private val companyProductRepository: ICompanyProductRepository) : ViewModel() {

    private val TAG = "PRODUCTBYCOMPANY"

    private var _products: MutableLiveData<Resource<CompanyProductResponse>> = MutableLiveData()
    val products: LiveData<Resource<CompanyProductResponse>> = _products

    fun getCompaniesWithProducts(companyProductId: String, token: String) {
        viewModelScope.launch {
            val response = companyProductRepository.productsByCompanyID(companyProductId, token)
            _products.value = response
        }
    }
}
