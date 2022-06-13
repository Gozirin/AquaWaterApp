package com.decagon.aqua.models.updatepassword

data class UpdatePasswordResponseModel(
    val statusCode: String,
    val success: Boolean,
    val Message: String,
    val errors: String?
)
