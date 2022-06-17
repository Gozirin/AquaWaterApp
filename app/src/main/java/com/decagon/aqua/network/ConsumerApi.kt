package com.decagon.aqua.network

import com.decagon.aqua.models.companyProductmodel.CompanyProductResponse
import com.decagon.aqua.models.consumerAuthModule.consumerhomepage.AllCompaniesWithFeaturedProduct
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ConsumerApi {

    @GET("/api/Product/GetProductsByCompanyID")
    suspend fun getProductsByCompanyID(
        @Header("Authorization") authToken: String,
        @Query("Data.CompanyId") productCompanyId: String,
        @Query("PageSize") pageSize: Int = 10,
        @Query("Page") page: Int = 1
    ): Response<CompanyProductResponse>

    @GET("/api/Company/GetAllCompaniesWithFeaturedProduct")
    suspend fun getCompaniesWithProducts(
        @Query("PageSize") pageSize: Int = 10,
        @Query("Page") page: Int = 1
    ): Response<AllCompaniesWithFeaturedProduct>
}
