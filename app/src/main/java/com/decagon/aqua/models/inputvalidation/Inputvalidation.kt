package com.decagon.aqua.models.inputvalidation

import android.util.Patterns
import com.decagon.aqua.feature.consumer.ui.consumptionFragments.ConsumerChangePasswordScreenFragment
import com.decagon.aqua.models.inputvalidation.Inputvalidation.validatePassword


object Inputvalidation {

    val validatePassword = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,15}\$")


    fun validateNewPassword(password: String): Boolean {
        return if (password.isEmpty()){
            false
        } else if (!validatePassword.matches(password)){
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


    // function to check if the two fields are  equal
        fun validateCurrentPasswordAndOldPasswordAndConfirmPassword(
            newPassword: String,
            confirmPassword: String
        ): Boolean {
            val result = newPassword == confirmPassword
            return result
        }

        fun validateNotEmptyNewPasswordField(newPassword: String): Boolean{
            val result = newPassword.isNotEmpty()
            return result
        }
    }














//var result = false
//
//object Inputvalidation {
//
//    fun ConsumerChangePasswordScreenFragment(email: String): String? {
//        if (email.isEmpty()) {
//            return " Enter a valid Email Address."
//        }
//        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            return "Invalid Email Address."
//        }
//        return null
//    }
//
//    fun validatePassword(passwordText: String): String? {
//        if (passwordText.isEmpty()) {
//            return "Password cannot be empty"
//        }
//        if (passwordText.length < 6) {
//            return "Password must have a minimum of 8 characters."
//        }
//        if (!passwordText.matches(".*[0-9].*".toRegex())) {
//            return "Password must contain at least 1 number."
//        }
//        if (!passwordText.matches(".*[A-Z].*".toRegex())) {
//            return "Password must contain at least 1 upper case character."
//        }
//        if (!passwordText.matches(".*[a-z].*".toRegex())) {
//            return "Password must contain at least 1 lower case character."
//        }
//        if (!passwordText.matches(".*[`~!@#$%^&*()\\-_=+|}{\\]\\[\"\';:?/>.<,].*".toRegex())) {
//            return "Password must contain at least 1 special character (@#$%&?!)."
//        }
//        return null
//    }
//    fun validateNewPassword(newPassword: String): Boolean{
//        // val checkedNewPassword = Regex("^(?=.*[A-Z].*[A-Z])(?=.*[!@#\$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}\$")
//        val checkedNewPassword = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@,#$%^&*]).{8,}\$")
//        result = newPassword.contains(checkedNewPassword)
//        return result
//    }
////
//    // function to check if the two fields are  equal
//    fun validateCurrentPasswordAndOldPasswordAndConfirmPassword(
//        newPassword: String,
//        confirmPassword: String
//    ): Boolean {
//        result = newPassword == confirmPassword
//        return result
//    }
//    fun validateNotEmptyNewPasswordField(newPassword: String): Boolean{
//        result = newPassword.isNotEmpty()
//        return result
//    }
//}
