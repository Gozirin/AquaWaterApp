package com.decagon.aqua.models.repository

import com.decagon.aqua.models.updatepassword.UpdatePasswordRequest
import com.decagon.aqua.models.updatepassword.UpdatePasswordResponseModel

interface IUpdatePasswordRepository {
    suspend fun updatePassword(updatePasswordRequest: UpdatePasswordRequest): UpdatePasswordResponseModel
}
