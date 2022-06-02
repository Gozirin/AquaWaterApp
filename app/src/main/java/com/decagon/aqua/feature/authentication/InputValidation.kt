package com.decagon.aqua.feature.authentication

import android.util.Patterns
object InputValidation {
    fun validateEmail(email: String): String? {
        if (email.isEmpty()) {
            return " Enter a valid Email Address."
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return "Invalid Email Address."
        }
        return null
    }
}
