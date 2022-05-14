package com.decagon.aqua.models

data class UserX(
    val age: Int,
    val confirmPassword: String,
    val email: String,
    val firstName: String,
    val gender: String,
    val lastName: String,
    val location: LocationX,
    val password: String,
    val phoneNumber: String,
    val profilePictureUrl: String
)
