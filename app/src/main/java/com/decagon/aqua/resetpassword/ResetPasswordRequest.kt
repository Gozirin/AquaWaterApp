package com.decagon.aqua.resetpassword

import com.google.gson.annotations.SerializedName

data class ResetPasswordRequest(

     @SerializedName("newPassword")
     val newPassword: String,
     @SerializedName("confirmPassword")
     val confirmPassword: String

)
