package com.decagon.aqua.feature.consumer.authentication

import com.decagon.aqua.core.data.UserRequest
import com.decagon.aqua.core.data.UserResponse
import retrofit2.Response

interface AquaRepositoryInterface {
    suspend fun login(userRequest: UserRequest): Response<UserResponse>
}
