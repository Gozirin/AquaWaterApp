package com.decagon.aqua.resetpassword

import com.google.gson.annotations.SerializedName

data class ResetPasswordData(
    @SerializedName("id")
    val email: String,
    @SerializedName("token")
    val token: String
)
