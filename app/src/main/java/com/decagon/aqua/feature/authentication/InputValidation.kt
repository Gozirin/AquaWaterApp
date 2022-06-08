package com.decagon.aqua.feature.authentication

import android.util.Patterns
var result = false
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
    fun validatePassword(passwordText: String): String? {
        if (passwordText.isEmpty()) {
            return "Password cannot be empty"
        }
        if (passwordText.length < 6) {
            return "Password must have a minimum of 6 characters."
        }
        if (!passwordText.matches(".*[0-9].*".toRegex())) {
            return "Password must contain at least 1 number."
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())) {
            return "Password must contain at least 1 upper case character."
        }
        if (!passwordText.matches(".*[a-z].*".toRegex())) {
            return "Password must contain at least 1 lower case character."
        }
        if (!passwordText.matches(".*[`~!@#$%^&*()\\-_=+|}{\\]\\[\"\';:?/>.<,].*".toRegex())) {
            return "Password must contain at least 1 special character (@#$%&?!)."
        }
        return ""
    }

    fun validateNewPassword(newPassword: String): Boolean {
        // val checkedNewPassword = Regex("^(?=.*[A-Z].*[A-Z])(?=.*[!@#\$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}\$")

        val checkedNewPassword = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@,#$%^&*]).{8,}\$")
        result = newPassword.contains(checkedNewPassword)
        return result
    }

    // function to check if the two fields are  equal
    fun validateNewPasswordAndConfirmPassword(newPassword: String, confirmPassword: String): Boolean {
        result = newPassword == confirmPassword
        return result
    }
    fun validateNotEmptyNewPasswordField(newPassword: String): Boolean {
        result = newPassword.isNotEmpty()
        return result
    }
}
