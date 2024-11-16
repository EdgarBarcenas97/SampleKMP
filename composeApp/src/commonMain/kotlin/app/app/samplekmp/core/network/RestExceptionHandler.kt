package app.app.samplekmp.core.network

import app.app.samplekmp.core.extensions.empty
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.utils.io.errors.IOException
import io.ktor.http.HttpStatusCode.Companion.Unauthorized
import io.ktor.http.HttpStatusCode.Companion.InternalServerError
import io.ktor.http.HttpStatusCode.Companion.NotFound
import app.app.samplekmp.core.network.KtorRequestException.ConnectionNetworkException
import app.app.samplekmp.core.network.KtorRequestException.AuthenticationException
import app.app.samplekmp.core.network.KtorRequestException.UnavailableServerException
import app.app.samplekmp.core.network.KtorRequestException.NotFoundException
import app.app.samplekmp.core.network.KtorRequestException.ClientException

fun handleRestException(exception: Exception) =
    if (exception is IOException) ConnectionNetworkException else exception

suspend fun throwExceptionMethod(httpResponse: HttpResponse) {
    getMessage(httpResponse).run {
        throw when {
            httpResponse.status == Unauthorized -> AuthenticationException(String.empty())
            httpResponse.status >= InternalServerError -> UnavailableServerException(String.empty())
            httpResponse.status == NotFound -> NotFoundException(String.empty())
            else -> ClientException(String.empty())
        }
    }
}

suspend fun getMessage(httpResponse: HttpResponse) = httpResponse.body<ErrorApiResponse>().message