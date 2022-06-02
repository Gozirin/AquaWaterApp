package com.decagon.aqua.core.api

import com.decagon.aqua.core.data.UserLoginRequest
import com.decagon.aqua.core.data.UserLoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AquaApi {
    @POST("/api/v1/Account/login")
    suspend fun login(
        @Body userLoginRequest: UserLoginRequest
    ): UserLoginResponse

//    @POST("/api/v1/Account/login")
//    suspend fun login(@Body userLoginRequest: UserLoginRequest): UserLoginResponse
}
