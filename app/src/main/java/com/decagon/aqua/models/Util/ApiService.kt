package com.decagon.aqua.models.Util

import com.decagon.aqua.models.updatepassword.UpdatePasswordRequest
import com.decagon.aqua.models.updatepassword.UpdatePasswordResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/api/v1/Account/UpdatePassword")
    suspend fun updatePassword(@Body updatePasswordRequest: UpdatePasswordRequest): UpdatePasswordResponseModel
}
