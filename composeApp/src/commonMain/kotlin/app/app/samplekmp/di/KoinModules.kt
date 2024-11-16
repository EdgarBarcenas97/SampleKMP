package app.app.samplekmp.di

import androidx.room.RoomDatabase
import app.app.samplekmp.app.profile.data.UserDao
import app.app.samplekmp.app.profile.data.UserDatabase
import app.app.samplekmp.core.network.httpClient
import io.ktor.client.HttpClient
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val appModule = module {
    single<UserDao> {
        val dbBuilder = get<RoomDatabase.Builder<UserDatabase>>()
        dbBuilder.build().userDao()
    }
}

private val networkModule = module {
    includes(httpClientEngineModule)
    single<HttpClient>{
        httpClient(httpClientEngine = get())
    }
}
expect val nativeModule: Module
internal expect val httpClientEngineModule: Module

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(appModule, nativeModule, networkModule)
    }
}
