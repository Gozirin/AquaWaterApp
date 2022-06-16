package com.decagon.aqua.feature.login_and_registration.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.commons.Resource
import com.decagon.aqua.models.ProductByCompanyID
import com.decagon.aqua.repositories.companyproductrepository.ICompanyProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject



class ProductByCompanyIDViewModel @Inject constructor(private val companyProductRepository: ICompanyProductRepository) : ViewModel() {

    private val TAG = "PRODUCTBYCOMPANY"

    private var _products: MutableLiveData<Resource<ProductByCompanyID>> = MutableLiveData()
    val products: LiveData<Resource<ProductByCompanyID>> = _products

    fun getCompaniesWithProducts(companyProductId: String, token: String) {
        viewModelScope.launch {
            val response = companyProductRepository.productsByCompanyID(companyProductId, token)
            Log.d(TAG, "here is the response from api: ${response.data}")
            _products.value = response
        }
    }
}
