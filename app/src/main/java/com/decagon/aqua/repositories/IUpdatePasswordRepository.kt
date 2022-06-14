package com.decagon.aqua.repositories

import com.decagon.aqua.models.updatepassword.UpdatePasswordModel
import com.decagon.aqua.models.updatepassword.UpdatePasswordResponseModel

interface IUpdatePasswordRepository {
    suspend fun updatePassword(authToken: String, updatePasswordRequest: UpdatePasswordModel): UpdatePasswordResponseModel
}
