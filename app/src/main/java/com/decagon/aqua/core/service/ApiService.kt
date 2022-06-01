package com.decagon.aqua.core.service
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordRequest
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordResponse
import retrofit2.http.* // ktlint-disable no-wildcard-imports

/**
 * Set up interface for network calls.
 * Annotation @POST makes request to add new data to the API,
 * @GET requests data from API
 * @PATCH and @PUT updates data in API.
 * @PATCH modifies while @PUT replaces.
 */
interface ApiService {

    @POST("/api/v1/Account/Reset-Password")
    suspend fun resetPassword(
        @Body resetPasswordRequest: ResetPasswordRequest
    ): ResetPasswordResponse
}
