package com.decagon.aqua.feature.repository

import com.decagon.aqua.core.service.ApiService
import com.decagon.aqua.feature.ForgotPassword.ForgotPasswordResponse
import com.decagon.aqua.feature.ForgotPassword.ForgotPasswordRequest
import retrofit2.Response

class ForgotPasswordRepository (
    private val apiService: ApiService
) : IForgotPasswordRepository {
    override suspend fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest): Response<ForgotPasswordResponse> {
        return apiService.forgetPassword(forgotPasswordRequest)
    }
}