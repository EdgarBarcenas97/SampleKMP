package app.app.samplekmp.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module

internal actual val httpClientEngineModule = module {
    single<HttpClientEngine> { Darwin.create {} }
}
