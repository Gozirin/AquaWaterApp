package com.decagon.aqua.feature.consumer.authentication

import com.decagon.aqua.core.data.UserSignUpResponse
import com.decagon.aqua.models.Consumer
import com.decagon.aqua.utils.Resource

interface AquaRepositoryInterface {
    suspend fun signUp(signUpRequest: Consumer): Resource<UserSignUpResponse>
}
