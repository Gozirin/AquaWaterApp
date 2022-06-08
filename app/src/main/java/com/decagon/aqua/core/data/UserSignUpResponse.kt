package com.decagon.aqua.core.data

import com.decagon.aqua.models.Location
import com.decagon.aqua.models.consumerAuthModule.User

data class UserSignUpResponse(
    val success: Boolean,
    val user: User,
    val location: Location,
    val message: String,
    val error: String
)
