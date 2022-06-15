package com.decagon.aqua.network

import com.decagon.aqua.core.data.UserSignUpResponse
import com.decagon.aqua.models.Consumer
import com.decagon.aqua.models.Supplier
import com.decagon.aqua.models.consumerAuthModule.getcompanieswithfeaturedproduct.AllCompaniesWithFeaturedProduct
import com.decagon.aqua.models.supplierAuthModule.* // ktlint-disable no-wildcard-imports
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SupplierAuthApi {

    @POST("/CompanyManager")
    suspend fun addSuppiler(
        @Body
        supplier: Supplier
    ): Response<RegisterResponse>

    @GET("/api/Company/GetAllCompanies")
    suspend fun getCompanies(): Response<CompanyList>

    @POST("/api/v1/Account/confirm-email")
    suspend fun confirmEmail(
        @Body
        confirmEmailModel: ConfirmEmailModel
    ): Response<RegisterResponse>

    @POST("/api/v1/Account/login")
    suspend fun logIn(
        @Body
        loginModel: LoginModel
    ): Response<LoginResponse>

    @POST("/api/v1/Customer")
    suspend fun consumerSignUp(
        @Body userSignUpRequest: Consumer
    ): Response<UserSignUpResponse>

    @GET("/api/Company/GetAllCompaniesWithFeaturedProduct")
    suspend fun getCompaniesWithProducts(
        @Query("PageSize") pageSize: Int = 10,
        @Query("Page") page: Int = 1
    ): Response<AllCompaniesWithFeaturedProduct>
}
