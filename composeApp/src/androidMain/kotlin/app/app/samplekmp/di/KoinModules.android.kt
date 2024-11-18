package app.app.samplekmp.di

import app.app.samplekmp.core.network.HTTP_TIMEOUT_MS
import app.app.samplekmp.database.getDatabaseBuilder
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import java.util.concurrent.TimeUnit
import org.koin.dsl.module

actual val nativeModule = module {
    single { getDatabaseBuilder(get()) }
}

internal actual val httpClientEngineModule = module {
    single<HttpClientEngine> {
        OkHttp.create {
            config {
                connectTimeout(HTTP_TIMEOUT_MS, TimeUnit.MILLISECONDS)
                writeTimeout(HTTP_TIMEOUT_MS, TimeUnit.MILLISECONDS)
                readTimeout(HTTP_TIMEOUT_MS, TimeUnit.MILLISECONDS)
            }
            //addInterceptor(get())
        }
    }
}
