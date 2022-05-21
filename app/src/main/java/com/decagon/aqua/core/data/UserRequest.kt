package com.decagon.aqua.core.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("email")
    @Expose
    var email: String? = null,

    @SerializedName("password")
    @Expose
    var password: String? = null
)
