package app.app.samplekmp.di

import app.app.samplekmp.data.database.getDatabaseBuilder
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module

actual val nativeModule = module {
    single { getDatabaseBuilder() }
}

internal actual val httpClientEngineModule = module {
    single<HttpClientEngine> { Darwin.create {} }
}
