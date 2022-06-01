package com.decagon.hbapplicationgroupa.model.authmodule.resetpassword

import com.decagon.aqua.resetpassword.ResetPasswordData
import com.google.gson.annotations.SerializedName

data class ResetPasswordResponse(
    @SerializedName("statusCode")
    val statusCode: String,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val data: ResetPasswordData,
    @SerializedName("message")
    val message: String,
    @SerializedName("error")
    val errors: String?
)
