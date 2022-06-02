package com.decagon.aqua.feature.consumer.authentication

import com.decagon.aqua.commons.util.Resource
import com.decagon.aqua.commons.util.apiCall
import com.decagon.aqua.core.api.AquaApi
import com.decagon.aqua.core.data.UserLoginRequest
import com.decagon.aqua.core.data.UserLoginResponse
import javax.inject.Inject

class AquaRepositoryInterfaceImpl @Inject constructor(private val aquaApi: AquaApi) : AquaRepositoryInterface {
//    override suspend fun login(userRequest: UserLoginRequest): Response<UserLoginResponse> {
//        return aquaApi.login(userRequest)
//    }
    override suspend fun login(userLoginRequest: UserLoginRequest): Resource<UserLoginResponse> {
        return apiCall {
            aquaApi.login(userLoginRequest)
        }
    }
}
