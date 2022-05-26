package com.decagon.hbapplicationgroupa.model.authmodule.resetpassword

import com.decagon.aqua.models.UserModule

data class ResetPasswordResponseModel(
    val statusCode: String,
    val success: Boolean,
    val Data: UserModule,
    val Message: String,
    val errors: String?
)
