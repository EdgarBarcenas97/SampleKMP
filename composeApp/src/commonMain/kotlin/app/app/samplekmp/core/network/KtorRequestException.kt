package app.app.samplekmp.core.network

sealed class KtorRequestException(val error: String? = null) : Exception() {
    data class AuthenticationException(val httpResponse: String) : KtorRequestException(error = httpResponse)
    data class ClientException(val httpResponse: String) : KtorRequestException(error = httpResponse)
    data class UnavailableServerException(val httpResponse: String) : KtorRequestException(error = httpResponse)
    data object ConnectionNetworkException : KtorRequestException()
    data class NotFoundException(val httpResponse: String) : KtorRequestException(error = httpResponse)
}
