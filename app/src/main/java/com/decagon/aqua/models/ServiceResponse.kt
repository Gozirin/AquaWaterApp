package com.decagon.aqua.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ServiceResponse {

    class ServiceResponse : Serializable {
        @SerializedName("Success")
        var success: Boolean = false
        @SerializedName("Success")
        lateinit var message1: String

        fun getMessage(): String {
            return message1
        }
        fun getResult(): Boolean {
            return success
        }
    }
}
