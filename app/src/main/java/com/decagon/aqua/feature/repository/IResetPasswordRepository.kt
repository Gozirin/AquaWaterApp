package com.decagon.aqua.feature.repository

import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordRequest
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordResponse

interface IResetPasswordRepository {
    suspend fun resetPassword(
        resetPasswordRequest: ResetPasswordRequest
    ): ResetPasswordResponse
}
