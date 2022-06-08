package com.decagon.aqua.feature.repository

import com.decagon.aqua.feature.ForgotPassword.ForgotPasswordResponse
import com.decagon.aqua.feature.ForgotPassword.ForgotPasswordRequest
import retrofit2.Response

interface IForgotPasswordRepository {
    suspend fun forgotPassword(
      forgotPasswordRequest: ForgotPasswordRequest

    ): Response<ForgotPasswordResponse>
}