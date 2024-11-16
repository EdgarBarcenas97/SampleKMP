package app.app.samplekmp.core.result

import app.app.samplekmp.core.result.Result.Success
import app.app.samplekmp.core.result.Result.Error

sealed interface Result<out R> {
    class Success<out R>(val value: R) : Result<R>
    class Error(val exception: Throwable) : Result<Nothing>
}

fun <T : Any> Result<T>.error(message: String? = null) = (this as? Error)?.exception ?: Exception(message ?: "unknown error")

fun <T : Any> Result<T>.success() = (this as? Success)?.value
