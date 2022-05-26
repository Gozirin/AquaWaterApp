package com.decagon.aqua.models
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordModel
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordResponseModel
import retrofit2.Response
import retrofit2.http.* // ktlint-disable no-wildcard-imports

/**
 * Set up interface for network calls.
 * Annotation @POST makes request to add new data to the API,
 * @GET requests data from API
 * @PATCH and @PUT updates data in API.
 * @PATCH modifies while @PUT replaces.
 */
interface AuthAppModule {

    @PATCH("/api/v1/Account/Reset-Password")
    suspend fun resetPassword(
        @Body resetPasswordModel: ResetPasswordModel
    ): Response<ResetPasswordResponseModel>
}
