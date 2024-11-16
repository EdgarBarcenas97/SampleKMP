package app.app.samplekmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform