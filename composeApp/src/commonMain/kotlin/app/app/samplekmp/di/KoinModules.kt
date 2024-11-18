package app.app.samplekmp.di

import androidx.room.RoomDatabase
import app.app.samplekmp.app.auth.signup.SignUpViewModel
import app.app.samplekmp.app.home.di.tracksModule
import app.app.samplekmp.app.home.ui.HomeViewModel
import app.app.samplekmp.app.profile.data.UserDao
import app.app.samplekmp.app.profile.data.UserDatabase
import app.app.samplekmp.app.profile.data.UserRepository
import app.app.samplekmp.app.profile.domain.GetUserFlowUseCase
import app.app.samplekmp.app.profile.domain.GetUserUseCase
import app.app.samplekmp.app.profile.domain.InsertUserUseCase
import app.app.samplekmp.core.network.httpClient
import io.ktor.client.HttpClient
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val appModule = module {
    single<UserDao> {
        val dbBuilder = get<RoomDatabase.Builder<UserDatabase>>()
        dbBuilder.build().userDao()
    }
}

val dataModule = module {
    factoryOf(::UserRepository)
    factoryOf(::InsertUserUseCase)
    factoryOf(::GetUserUseCase)
    factoryOf(::GetUserFlowUseCase)
}

private val networkModule = module {
    includes(httpClientEngineModule)
    single<HttpClient>{
        httpClient(httpClientEngine = get())
    }
}

expect val nativeModule: Module
internal expect val httpClientEngineModule: Module

val viewModelModule = module {
    viewModelOf(::SignUpViewModel)
    viewModelOf(::HomeViewModel)
}

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(appModule, dataModule, tracksModule, nativeModule, viewModelModule, networkModule)
    }
}
