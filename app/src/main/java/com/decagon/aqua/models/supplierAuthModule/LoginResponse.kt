package com.decagon.aqua.models.supplierAuthModule

data class LoginResponse(
    val `data`: DataX,
    val errors: Any,
    val message: String,
    val success: Boolean
)
