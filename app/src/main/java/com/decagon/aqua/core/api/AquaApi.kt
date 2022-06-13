package com.decagon.aqua.core.api

import com.decagon.aqua.core.data.UserLoginRequest
import com.decagon.aqua.core.data.UserLoginResponse
import com.decagon.aqua.models.SupplyDetailsItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AquaApi {
    @POST("/api/v1/Account/login")
    suspend fun login(
        @Body userLoginRequest: UserLoginRequest
    ): UserLoginResponse

    @GET("/api/Product/GetProductsByCompanyID")
    suspend fun getProductsByCompanyID(): Response<List<SupplyDetailsItem>>
}
