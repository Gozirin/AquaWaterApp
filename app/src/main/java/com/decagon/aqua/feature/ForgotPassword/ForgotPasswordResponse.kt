package com.decagon.aqua.feature.ForgotPassword

import com.google.gson.annotations.SerializedName

data class ForgotPasswordResponse(
    @SerializedName("statusCode")
    val statusCode: String,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("errors")
    val errors: String?
)
