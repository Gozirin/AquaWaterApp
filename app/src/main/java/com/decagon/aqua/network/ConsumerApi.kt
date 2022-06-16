package com.decagon.aqua.network

import com.decagon.aqua.models.ProductByCompanyID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CompanyProductApi {

    @GET("/api/Product/GetProductsByCompanyID")
    suspend fun getProductsByCompanyID(
        @Header("Authorization") authToken: String,
        @Query("CompanyId") productCompanyId: String
    ): Response<List<ProductByCompanyID>>
}
