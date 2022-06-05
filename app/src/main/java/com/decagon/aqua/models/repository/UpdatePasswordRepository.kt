package com.decagon.aqua.models.repository

import com.decagon.aqua.models.Util.ApiService
import com.decagon.aqua.models.updatepassword.UpdatePasswordRequest
import com.decagon.aqua.models.updatepassword.UpdatePasswordResponseModel

class UpdatePasswordRepository(
    private val apiService: ApiService
) : IUpdatePasswordRepository {
    // Single Truth
    override suspend fun updatePassword(updatePasswordRequest: UpdatePasswordRequest): UpdatePasswordResponseModel {
        return apiService.updatePassword(updatePasswordRequest)
    }
}
