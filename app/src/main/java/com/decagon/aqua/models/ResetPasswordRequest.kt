package com.decagon.aqua.models

import com.google.gson.annotations.SerializedName

data class ResetPasswordRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("token")
    val token: String

)
