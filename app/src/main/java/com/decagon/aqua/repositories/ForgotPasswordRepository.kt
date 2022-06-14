package com.decagon.aqua.repositories

import com.decagon.aqua.models.ForgotPasswordRequest
import com.decagon.aqua.models.ForgotPasswordResponse
import com.decagon.aqua.network.ForgotResetPassWordAPI
import retrofit2.Response

class ForgotPasswordRepository(
    private val forgotResetPassWordAPI: ForgotResetPassWordAPI
) : IForgotPasswordRepository {
    override suspend fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest): Response<ForgotPasswordResponse> {
        return forgotResetPassWordAPI.forgetPassword(forgotPasswordRequest)
    }
}
