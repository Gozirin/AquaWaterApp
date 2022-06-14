package com.decagon.aqua.models

import com.google.gson.annotations.SerializedName

data class ResetPasswordRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("email")
    val token: String,
    @SerializedName("newPassword")
    val newPassword: String,
    @SerializedName("confirmPassword")
    val confirmPassword: String

)
