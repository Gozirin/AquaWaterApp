package com.decagon.aqua.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserSignUpRequest(
    @SerializedName("confirmPassword")
    @Expose
    val confirmPassword: String? = null,

    @SerializedName("email")
    @Expose
    val email: String? = null,

    @SerializedName("firstName")
    @Expose
    val firstName: String? = null,

    @SerializedName("gender")
    @Expose
    val gender: String? = null,

    @SerializedName("lastName")
    @Expose
    val lastName: String? = null,

    @SerializedName("phoneNumber")
    @Expose
    val phoneNumber: String? = null,

    @SerializedName("profilePictureUrl")
    @Expose
    val profilePictureUrl: String? = null,

    @SerializedName("state")
    @Expose
    val state: String? = null,

    @SerializedName("city")
    @Expose
    val city: String? = null,

    @SerializedName("street")
    val street: String? = null,

    @SerializedName("password")
    val password: String? = null

)
