package app.app.samplekmp.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal fun httpClient(httpClientEngine: HttpClientEngine) = HttpClient(httpClientEngine) {
    expectSuccess = true
    HttpResponseValidator {
        handleResponseExceptionWithRequest { exception, _ ->
            when (exception) {
                is ClientRequestException -> throwExceptionMethod(exception.response)
                is ServerResponseException -> throwExceptionMethod(exception.response)
            }
        }
    }
    install(HttpTimeout) {
        requestTimeoutMillis = HTTP_TIMEOUT_MS
        socketTimeoutMillis = HTTP_TIMEOUT_MS
        connectTimeoutMillis = HTTP_TIMEOUT_MS
    }
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            ignoreUnknownKeys = true
            useAlternativeNames = false
        })
    }
    defaultRequest {
        url("http://apk.ctn.smapps.mx:9582" )
    }
}

internal const val HTTP_TIMEOUT_MS = 30_000L
