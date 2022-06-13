package com.decagon.aqua.feature.authentication

var result = false
object InputValidation {

    private var EMAIL_PATTERN = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$")
    private val validatePassword = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,15}\$")

    fun validateNewPassword(password: String): Boolean {
        return if (password.isEmpty()) {
            false
        } else if (!validatePassword.matches(password)) {
            false
        } else {
            true
        }
    }

    fun validateConfirmPassword(password: String, confirmPassword: String): Boolean {
        if (password != confirmPassword) {
            return false
        }
        return true
    }

    fun validateEmailInput(email: String): Boolean {
        if (email.isEmpty() || !email.matches(EMAIL_PATTERN)) {
            return false
        }
        return true
    }

    fun validateEmail(email: String): String? {
        if (email.isEmpty()) {
            return "Enter a valid Email Address"
        }
        if (!email.matches(EMAIL_PATTERN)) {
            return "Invalid Email Address"
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

//    fun validateNewPassword(newPassword: String): Boolean {
//        // val checkedNewPassword = Regex("^(?=.*[A-Z].*[A-Z])(?=.*[!@#\$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}\$")
//
//        val checkedNewPassword = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@,#$%^&*]).{8,}\$")
//        result = newPassword.contains(checkedNewPassword)
//        return result
//    }

    // function to check if the two fields are  equal
//    fun validateNewPasswordAndConfirmPassword(newPassword: String, confirmPassword: String): Boolean {
//        result = newPassword == confirmPassword
//        return result
//    }
    fun validateNotEmptyNewPasswordField(newPassword: String): Boolean {
        result = newPassword.isNotEmpty()
        return result
    }
}
