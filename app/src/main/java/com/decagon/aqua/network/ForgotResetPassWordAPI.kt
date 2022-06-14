package com.decagon.aqua.network
import com.decagon.aqua.models.ForgotPasswordRequest
import com.decagon.aqua.models.ForgotPasswordResponse
import com.decagon.aqua.models.ResetPasswordRequest
import com.decagon.aqua.models.ResetPasswordResponse
import retrofit2.Response
import retrofit2.http.* // ktlint-disable no-wildcard-imports

/**
 * Set up interface for network calls.
 * Annotation @POST makes request to add new data to the API,
 * @GET requests data from API
 * @PATCH and @PUT updates data in API.
 * @PATCH modifies while @PUT replaces.
 */
interface ForgotResetPassWordAPI {

    @POST("/api/v1/Account/Reset-Password")
    suspend fun resetPassword(
        @Body resetPasswordRequest: ResetPasswordRequest
    ): ResetPasswordResponse

    @POST("/api/v1/Account/Forgot-Password")
    suspend fun forgetPassword(
        @Body forgotPasswordRequest: ForgotPasswordRequest
    ): Response<ForgotPasswordResponse>
}
