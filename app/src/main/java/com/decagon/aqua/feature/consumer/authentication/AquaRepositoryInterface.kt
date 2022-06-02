package com.decagon.aqua.feature.consumer.authentication

import com.decagon.aqua.commons.util.Resource
import com.decagon.aqua.core.data.UserLoginRequest
import com.decagon.aqua.core.data.UserLoginResponse

interface AquaRepositoryInterface {
    suspend fun login(userRequest: UserLoginRequest): Resource<UserLoginResponse>
    // suspend fun login(userLoginRequest: UserLoginRequest): UserLoginResponse
}
