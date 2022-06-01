package com.decagon.hbapplicationgroupa.model.authmodule.resetpassword

data class ResetPasswordResponseModel(
    val statusCode: String,
    val success: Boolean,
    val Message: String,
    val errors: String?
)
