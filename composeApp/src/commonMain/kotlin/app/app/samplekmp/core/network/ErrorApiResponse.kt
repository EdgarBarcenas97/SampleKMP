package app.app.samplekmp.core.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorApiResponse(
    @SerialName("message")
    val message: String? = null)
