package com.decagon.aqua.feature.repository

import com.decagon.aqua.core.service.ApiService
import com.decagon.aqua.models.ResetPasswordRequest
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordResponse

class ResetPasswordRepository(
    private val apiService: ApiService
) : IResetPasswordRepository {
    override suspend fun resetPassword(resetPasswordRequest: ResetPasswordRequest): ResetPasswordResponse {
        return apiService.resetPassword(resetPasswordRequest)
    }
}
