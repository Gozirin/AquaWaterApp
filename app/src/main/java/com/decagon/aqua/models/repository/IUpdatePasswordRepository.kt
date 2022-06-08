package com.decagon.aqua.models.repository

import com.decagon.aqua.models.updatepassword.UpdatePasswordModel
import com.decagon.aqua.models.updatepassword.UpdatePasswordResponseModel

interface IUpdatePasswordRepository {
    suspend fun updatePassword(authToken: String, updatePasswordRequest: UpdatePasswordModel): UpdatePasswordResponseModel
}
