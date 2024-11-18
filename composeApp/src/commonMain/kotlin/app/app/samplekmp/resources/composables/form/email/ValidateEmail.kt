package app.app.samplekmp.resources.composables.form.email


fun validateEmail(email: String): EmailValidationResult {
    return when {
        email.isEmpty() -> EmailValidationResult.EMPTY
        //!email.matches(Regex(EMAIL_PATTERN)) -> EmailValidationResult.INVALID_FORMAT
        else -> EmailValidationResult.VALID
    }

}

fun isEmailValid(email: String): Boolean {
    return validateEmail(email) == EmailValidationResult.VALID
}

enum class EmailValidationResult {
    VALID, EMPTY, INVALID_FORMAT
}
