package com.decagon.aqua.feature.login_and_registration.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.aqua.commons.Resource
import com.decagon.aqua.models.consumerAuthModule.consumerhomepage.AllCompaniesWithFeaturedProduct
import com.decagon.aqua.repositories.IConsumerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConsumerViewModel @Inject constructor(private val repo: IConsumerRepository) : ViewModel() {

    private var _products: MutableLiveData<Resource<AllCompaniesWithFeaturedProduct>> = MutableLiveData()
    val products: LiveData<Resource<AllCompaniesWithFeaturedProduct>> = _products

    fun getCompaniesWithProducts() {
        viewModelScope.launch {
            val response = repo.getCompaniesProducts()
            _products.value = response
        }
    }
}
