package com.decagon.aqua.validations

import android.util.Patterns

object InputValidation {

    private var EMAIL_PATTERN = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$")
    private val validatePassword = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,15}\$")

    fun validateEmailInput(email: String): Boolean {
        if (email.isEmpty() || !email.matches(EMAIL_PATTERN)) {
            return false
        }
        return true
    }

    fun validateUserPassword(password: String): Boolean {
        return if (password.isEmpty()) {
            false
        } else if (!validatePassword.matches(password)) {
            false
        } else {
            true
        }
    }

    fun ValidateEmail(email: String): String? {
        if (email.isEmpty()) {
            return "Empty field. Enter a valid Email Address."
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
        if (passwordText.length < 8) {
            return "Password must have a minimum of 8 characters."
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
}
