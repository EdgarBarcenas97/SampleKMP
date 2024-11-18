package app.app.samplekmp.core.extensions


fun String.Companion.empty() = ""

fun String.Companion.space() = " "

fun String.capitalizeFirstChar() = replaceFirstChar { it.uppercaseChar() }

const val EMAIL_PATTERN = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
    "\\@" +
    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
    "(" +
    "\\." +
    "[a-zA-Z0-9][a-zA-Z0-9\\-]{1,25}" +
    ")+"

const val PASSWORD_PATTERN = "^" +
    "(?=.*[0-9])" +
    "(?=.*[a-z])" +
    "(?=.*[A-Z])" +
    "(?=.*[a-zA-Z])" +
    "(?=.*[-_@#$%^&+=])" +
    "(?=\\S+$)" +
    ".{8,}" +
    "$"

fun convertToHttps(url: String): String {
    return if (url.startsWith("http://")) {
        url.replaceFirst("http://", "https://")
    } else {
        url
    }
}