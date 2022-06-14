package com.decagon.aqua.models

import com.decagon.aqua.models.consumerAuthModule.User

data class UserSignUpResponse(
    val success: Boolean,
    val user: User,
    val location: Location,
    val message: String,
    val error: String
)
