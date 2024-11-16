package app.app.samplekmp.di

import app.app.samplekmp.core.network.httpClient
import io.ktor.client.HttpClient
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

private val networkModule = module {
    includes(httpClientEngineModule)
    single<HttpClient>{
        httpClient(httpClientEngine = get())
    }
}

internal expect val httpClientEngineModule: Module

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(networkModule)
    }
}
