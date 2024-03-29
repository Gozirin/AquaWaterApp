package com.decagon.aqua.models.updatepassword

import com.google.gson.annotations.SerializedName

data class UpdatePasswordRequest(
    @SerializedName("newPassword")
    val newPassword: String,
    @SerializedName("email")
    val confirmPassword: String,
    @SerializedName("oldPassword")
    val oldPassword: String
)
