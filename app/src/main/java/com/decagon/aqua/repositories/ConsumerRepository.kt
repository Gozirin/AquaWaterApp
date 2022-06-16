package com.decagon.aqua.repositories

import com.decagon.aqua.commons.Resource
import com.decagon.aqua.models.consumerAuthModule.consumerhomepage.AllCompaniesWithFeaturedProduct
import com.decagon.aqua.network.CompanyProductApi
import javax.inject.Inject

class ConsumerRepository @Inject constructor(private val consumerApi: CompanyProductApi) : IConsumerRepository, BaseRepository() {

    override suspend fun getCompaniesProducts(): Resource<AllCompaniesWithFeaturedProduct> {
        return safeApiCall { consumerApi.getCompaniesWithProducts() }
    }
}
