package com.decagon.aqua.repositories

import com.decagon.aqua.models.ResetPasswordRequest
import com.decagon.aqua.models.ResetPasswordResponse

interface IResetPasswordRepositoryInterface {
    suspend fun resetPassword(
        resetPasswordRequest: ResetPasswordRequest
    ): ResetPasswordResponse
}
