package com.decagon.aqua.network

import com.decagon.aqua.models.Supplier
import com.decagon.aqua.models.supplierAuthModule.CompanyList
import com.decagon.aqua.models.supplierAuthModule.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SupplierAuthApi {

    @POST("/CompanyManager")
    suspend fun addSuppiler(
        @Body
        supplier: Supplier
    ): Response<RegisterResponse>

    @GET("/api/Company/GetAllCompanies")
    suspend fun getCompanies(): Response<CompanyList>
}
