package com.decagon.aqua.core.data

data class UserLoginResponse(
    val success: Boolean,
    val data: Data,
    val message: String,
    val error: String
)
data class Data(
    val id: String,
    val token: String,
    val fullName: String,
    val email: String
)
//    @SerializedName("data")
//    @Expose
//    var data: User? = null
