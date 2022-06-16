package com.decagon.aqua.repositories.companyproductrepository

import com.decagon.aqua.models.companyProductmodel.CompanyProductResponse
import com.decagon.aqua.network.CompanyProductApi
import retrofit2.Response
import javax.inject.Inject

class CompanyProductRepository @Inject constructor(private val companyProductApi: CompanyProductApi) : ICompanyProductRepository {

    override suspend fun productsByCompanyID(
        productcompanyId: String,
        token: String
    ): Response<CompanyProductResponse> {
        return companyProductApi.getProductsByCompanyID(token, productcompanyId)
    }
}
