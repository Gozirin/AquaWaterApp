package com.decagon.aqua.models.repository

import com.decagon.aqua.models.Util.ApiService
import com.decagon.aqua.models.updatepassword.UpdatePasswordModel
import com.decagon.aqua.models.updatepassword.UpdatePasswordResponseModel
import javax.inject.Inject

class UpdatePasswordRepository @Inject constructor(
    private val apiService: ApiService
) : IUpdatePasswordRepository {
    // Single Truth
    override suspend fun updatePassword(authToken: String, updatePasswordRequest: UpdatePasswordModel): UpdatePasswordResponseModel {
        return apiService.updatePassword(authToken, updatePasswordRequest)
    }
}
