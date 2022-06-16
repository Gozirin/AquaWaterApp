package com.decagon.aqua.feature.login_and_registration.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.commons.Resource
import com.decagon.aqua.models.companyProductmodel.CompanyProductResponse
import com.decagon.aqua.repositories.companyproductrepository.ICompanyProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProductByCompanyIDViewModel @Inject constructor(private val companyProductRepository: ICompanyProductRepository) : ViewModel() {

    private val TAG = "PRODUCTBYCOMPANY"

    private var _products: MutableLiveData<Resource<Response<CompanyProductResponse>>> = MutableLiveData()
    val products: LiveData<Resource<Response<CompanyProductResponse>>> = _products

    fun getCompaniesWithProducts(companyProductId: String, token: String) {
        viewModelScope.launch {
            try {
                val response = companyProductRepository.productsByCompanyID(companyProductId, token)
                Log.d(TAG, "here is the response from api: ${response.body()}")
                _products.value = Resource.Success(response)
            } catch (e: Exception) {
                Resource.Error<String>(errorMessage = e.message.toString())
            }
        }
    }
}
