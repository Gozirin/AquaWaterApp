package com.decagon.aqua.feature.consumer.authentication

import com.decagon.aqua.api.AquaApi
import com.decagon.aqua.core.data.UserSignUpResponse
import com.decagon.aqua.models.Consumer
import com.decagon.aqua.utils.BaseRepository
import com.decagon.aqua.utils.Resource
import javax.inject.Inject

class AquaRepositoryInterfaceImpl @Inject constructor(private val aquaApi: AquaApi) : AquaRepositoryInterface, BaseRepository() {
    override suspend fun signUp(signUpRequest: Consumer): Resource<UserSignUpResponse> {
        return safeApiCall {
            aquaApi.signUp(signUpRequest)
        }
    }
}
