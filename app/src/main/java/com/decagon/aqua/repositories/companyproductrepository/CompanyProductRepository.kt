package com.decagon.aqua.repositories.companyproductrepository

import com.decagon.aqua.commons.Resource
import com.decagon.aqua.models.companyProductmodel.CompanyProductResponse
import com.decagon.aqua.network.ConsumerApi
import com.decagon.aqua.repositories.BaseRepository
import javax.inject.Inject

class CompanyProductRepository @Inject constructor(private val companyProductApi: ConsumerApi) : ICompanyProductRepository, BaseRepository() {

    override suspend fun productsByCompanyID(
        productcompanyId: String,
        token: String
    ): Resource<CompanyProductResponse> {
        return safeApiCall { companyProductApi.getProductsByCompanyID(token, productcompanyId) }
    }
}
