package app.app.samplekmp.core.extensions

private const val DEFAULT_VALUE = 0
private const val ONE = 1
private const val MINUS_ONE = -1
private const val ZERO_LONG = 0L

const val ZERO = 0

fun Int.Companion.default() = DEFAULT_VALUE

fun Int.Companion.one() = ONE

fun Int.Companion.minusOne() = MINUS_ONE

fun Int?.orDefault() = this ?: DEFAULT_VALUE

fun Int.isZero() = this == ZERO

fun Int.isGreaterZero() = this > ZERO

fun Long.Companion.default() = ZERO_LONG
