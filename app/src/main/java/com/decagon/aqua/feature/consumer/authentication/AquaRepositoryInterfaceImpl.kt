package com.decagon.aqua.feature.consumer.authentication

import com.decagon.aqua.core.api.AquaApi
import com.decagon.aqua.core.data.UserRequest
import com.decagon.aqua.core.data.UserResponse
import retrofit2.Response
import javax.inject.Inject

class AquaRepositoryInterfaceImpl @Inject constructor(private val aquaApi: AquaApi) : AquaRepositoryInterface {
    override suspend fun login(userRequest: UserRequest): Response<UserResponse> {
        return aquaApi.login(userRequest)
    }
}
