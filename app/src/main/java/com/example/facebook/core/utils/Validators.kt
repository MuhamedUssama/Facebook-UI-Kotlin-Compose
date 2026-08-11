package com.example.facebook.core.utils

private val EMAIL_REGEX = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")

fun validateEmail(email: String?): String? {
    return when {
        email.isNullOrEmpty() -> "Email cannot be empty"
        email.length < 3 -> "Email must be at least 3 characters"
        !EMAIL_REGEX.matches(email) -> "Invalid email address"
        else -> null
    }
}

fun validatePassword(password: String?): String? {
    return when {
        password.isNullOrEmpty() -> "Password cannot be empty"
        password.length < 6 -> "Password must be at least 6 characters"
        else -> null
    }
}