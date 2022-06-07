package com.decagon.aqua.api

import com.decagon.aqua.core.data.UserSignUpResponse
import com.decagon.aqua.models.Consumer
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AquaApi {

    @POST("/api/v1/Customer")
    suspend fun signUp(@Body userSignUpRequest: Consumer): Response<UserSignUpResponse>
}