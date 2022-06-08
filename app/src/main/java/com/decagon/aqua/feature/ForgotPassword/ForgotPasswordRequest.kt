package com.decagon.aqua.feature.ForgotPassword

import com.google.gson.annotations.SerializedName

data class ForgotPasswordRequest(
    @SerializedName("email")
    val email: String

)
