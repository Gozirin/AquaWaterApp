package com.decagon.aqua.models.updatepassword

import com.google.gson.annotations.SerializedName

data class UpdatePasswordModel(
    @SerializedName("newPassword")
    val newPassword: String,
    @SerializedName("confirmNewPassword")
    val confirmNewPassword: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("oldPassword")
    val oldPassword: String?
)
