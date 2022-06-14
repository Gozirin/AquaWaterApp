package com.decagon.aqua.validations

import android.util.Patterns
import java.util.regex.Pattern

object CustomerSignUpValidation

val phonePattern = Regex("([+]234|0)(7|8|9)[0-9]{9}")
val NAMING_PATTERN = Regex("[a-zA-Z]")
val PASSWORD_PATTERN: Pattern = Pattern.compile(
    "^" +
        "(?=.*[0-9])" + // at least 1 digit
        "(?=.*[a-z])" + // at least 1 lower case letter
        "(?=.*[A-Z])" + // at least 1 upper case letter
        "(?=.*[a-zA-Z])" + // any letter
        "(?=.*[@#$%^&+=*_-])" + // at least 1 special character
        ".{6,}" + // at least 4 characters
        "$"
)

fun validateFirstNameInput(firstName: String): String? {
    if (firstName.length < 2 || !firstName.contains(NAMING_PATTERN)) {
        return "Invalid name"
    }
    if (firstName.isEmpty()) {
        return "First name required"
    }
    return null
}

fun validateLastNameInput(lastName: String): String? {
    if (lastName.length < 2 || !lastName.contains(NAMING_PATTERN)) {
        return "Invalid name"
    }
    if (lastName.isEmpty()) {
        return "Last name required"
    }
    return null
}
fun validateEmailInput(email: String): String? {
    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        return "Invalid email"
    }
    if (email.isEmpty()) {
        return "Email required"
    }
    return null
}
fun validatePasswordInput(password: String): String? {
    if (!PASSWORD_PATTERN.matcher(password).matches() || password.length < 8) {
        return "Password must be a minimum of 8 characters and contain upper case and special characters"
    }
    return null
}
fun validatePhoneInput(phone: String): String? {
    if (phone.isEmpty() || !phone.matches(phonePattern)) {
        return "Invalid Phone number"
    }
    return null
}

fun validateStreet(street: String): String? {
    if (street.isEmpty()) {
        return "Input your street name!"
    }

    return null
}

fun validateCity(city: String): String? {
    if (city.isEmpty()) {
        return "Input your city!"
    }

    return null
}

fun validateState(state: String): String? {
    if (state.isEmpty()) {
        return "Input your state!"
    }

    return null
}
