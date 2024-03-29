package com.decagon.aqua.models.consumerAuthModule

import com.decagon.aqua.models.Location

data class User(
    val age: Int? = null,
    val confirmPassword: String,
    val email: String,
    val firstName: String,
    val gender: String? = null,
    val lastName: String,
    val location: Location,
    val password: String,
    val phoneNumber: String,
    val profilePictureUrl: String? = null
)
