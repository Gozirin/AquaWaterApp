package com.decagon.aqua.repositories

import com.decagon.aqua.models.ForgotPasswordRequest
import com.decagon.aqua.models.ForgotPasswordResponse
import retrofit2.Response

interface IForgotPasswordRepository {
    suspend fun forgotPassword(
        forgotPasswordRequest: ForgotPasswordRequest
    ): Response<ForgotPasswordResponse>
}
