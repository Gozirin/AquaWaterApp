package com.decagon.aqua.feature.repository

import com.decagon.aqua.resetpassword.ResetPasswordRequest
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordResponse

interface IResetPasswordRepositoryInterface {
    suspend fun resetPassword(
        resetPasswordRequest: ResetPasswordRequest
    ): ResetPasswordResponse
}
