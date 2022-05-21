package com.decagon.aqua.core.api

import com.decagon.aqua.core.data.UserRequest
import com.decagon.aqua.core.data.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AquaApi {
    @POST("/api/v1/Account/login")
    suspend fun login(
        @Body userRequest: UserRequest
    ): Response<UserResponse>
}
