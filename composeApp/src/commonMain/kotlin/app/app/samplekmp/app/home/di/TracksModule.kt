package app.app.samplekmp.app.home.di

import app.app.samplekmp.app.home.data.DiscoverTracksRemoteDataSource
import app.app.samplekmp.app.home.data.DiscoverTracksRepository
import app.app.samplekmp.app.home.data.IDiscoverTracksRemoteDataSource
import app.app.samplekmp.app.home.data.IDiscoverTracksRepository
import app.app.samplekmp.app.home.domain.FetchTrackUseCase
import app.app.samplekmp.app.home.domain.IFetchTrackUseCase
import org.koin.dsl.module

internal val tracksModule = module {
    factory<IDiscoverTracksRemoteDataSource> { DiscoverTracksRemoteDataSource(get()) }
    factory<IDiscoverTracksRepository> { DiscoverTracksRepository(get()) }
    factory<IFetchTrackUseCase> { FetchTrackUseCase(discoverTracksRepository = get()) }
}
