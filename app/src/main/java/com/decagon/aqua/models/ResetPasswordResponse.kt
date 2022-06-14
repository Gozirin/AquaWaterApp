package com.decagon.aqua.models

import com.google.gson.annotations.SerializedName

data class ResetPasswordResponse(
    @SerializedName("statusCode")
    val statusCode: String,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("error")
    val errors: String?
)
