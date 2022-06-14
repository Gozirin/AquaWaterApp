package com.decagon.aqua.network

import com.decagon.aqua.models.updatepassword.UpdatePasswordModel
import com.decagon.aqua.models.updatepassword.UpdatePasswordResponseModel
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.PATCH

interface ApiService {

    @PATCH("/api/v1/Account/UpdatePassword")
    suspend fun updatePassword(@Header("Authorization")authToken: String, @Body updatePasswordRequest: UpdatePasswordModel): UpdatePasswordResponseModel
}
