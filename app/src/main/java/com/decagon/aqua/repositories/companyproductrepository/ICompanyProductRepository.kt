package com.decagon.aqua.repositories.companyproductrepository

import com.decagon.aqua.models.companyProductmodel.CompanyProductResponse
import retrofit2.Response

interface ICompanyProductRepository {

    suspend fun productsByCompanyID(productcompanyId: String, token: String): Response<CompanyProductResponse>
}
