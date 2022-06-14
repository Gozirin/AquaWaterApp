package com.decagon.aqua.feature.onboarding

import com.decagon.aqua.models.ResetPasswordRequest
import com.decagon.aqua.models.ResetPasswordResponse
import com.decagon.aqua.network.ForgotResetPassWordAPI
import com.decagon.aqua.repositories.IResetPasswordRepositoryInterface

class ResetPasswordRepository(
    private val forgotResetPassWordAPI: ForgotResetPassWordAPI
) : IResetPasswordRepositoryInterface {
    override suspend fun resetPassword(resetPasswordRequest: ResetPasswordRequest): ResetPasswordResponse {
        return forgotResetPassWordAPI.resetPassword(resetPasswordRequest)
    }
}
