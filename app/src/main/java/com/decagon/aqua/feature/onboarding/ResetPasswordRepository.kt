package com.decagon.aqua.feature.onboarding

import com.decagon.aqua.core.service.ForgotResetPassWordAPI
import com.decagon.aqua.feature.repository.IResetPasswordRepositoryInterface
import com.decagon.aqua.resetpassword.ResetPasswordRequest
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordResponse

class ResetPasswordRepository(
    private val forgotResetPassWordAPI: ForgotResetPassWordAPI
) : IResetPasswordRepositoryInterface {
    override suspend fun resetPassword(resetPasswordRequest: ResetPasswordRequest): ResetPasswordResponse {
        return forgotResetPassWordAPI.resetPassword(resetPasswordRequest)
    }
}
