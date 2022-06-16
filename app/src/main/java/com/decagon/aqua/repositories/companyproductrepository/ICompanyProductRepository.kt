package com.decagon.aqua.repositories.companyproductrepository

import com.decagon.aqua.commons.Resource
import com.decagon.aqua.models.ProductByCompanyID

interface ICompanyProductRepository {

    suspend fun productsByCompanyID(productcompanyId: String, token: String): Resource<ProductByCompanyID>
}
