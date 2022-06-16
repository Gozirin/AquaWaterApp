package com.decagon.aqua.network

import com.decagon.aqua.models.ProductByCompanyID
import com.decagon.aqua.models.consumerAuthModule.consumerhomepage.AllCompaniesWithFeaturedProduct
import com.decagon.aqua.models.companyProductmodel.CompanyProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Header

interface CompanyProductApi {

    @GET("/api/Product/GetProductsByCompanyID")
    suspend fun getProductsByCompanyID(): Response<List<ProductByCompanyID>>

    @GET("/api/Company/GetAllCompaniesWithFeaturedProduct")
    suspend fun getCompaniesWithProducts(
        @Query("PageSize") pageSize: Int = 10,
        @Query("Page") page: Int = 1
    ): Response<AllCompaniesWithFeaturedProduct>
    suspend fun getProductsByCompanyID(
        @Header("Authorization") authToken: String,
        @Query("CompanyId") productCompanyId: String
    ): Response<CompanyProductResponse>
}
