package com.decagon.aqua.repositories.companyproductrepository

import com.decagon.aqua.commons.Resource
import com.decagon.aqua.models.ProductByCompanyID
import com.decagon.aqua.network.CompanyProductApi
import retrofit2.Response
import javax.inject.Inject

class CompanyProductRepository @Inject constructor(private val companyProductApi: CompanyProductApi): ICompanyProductRepository {

    override suspend fun productsByCompanyID(
        productcompanyId: ProductByCompanyID,
        token: String
    ): Resource<ProductByCompanyID> {
        TODO("Not yet implemented")
    }


}