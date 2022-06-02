package com.decagon.aqua.feature.repository // ktlint-disable filename

import com.decagon.aqua.core.service.ApiService
import com.decagon.aqua.models.ResetPasswordRequest
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordResponse

class AuthRepositoryInterface(
    private val apiService: ApiService
) : IResetPasswordRepositoryInterface {
    override suspend fun resetPassword(resetPasswordRequest: ResetPasswordRequest): ResetPasswordResponse {
        return apiService.resetPassword(resetPasswordRequest)
    }
}
