package com.decagon.aqua.feature.repository

import com.decagon.aqua.models.ResetPasswordRequest
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordResponse

interface IResetPasswordRepository {
    suspend fun resetPassword(
        resetPasswordRequest: ResetPasswordRequest
    ): ResetPasswordResponse
}
