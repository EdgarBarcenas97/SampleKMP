package app.app.samplekmp.app.home.data

import app.app.samplekmp.core.result.Result

internal interface IDiscoverTracksRepository {
    suspend fun fetchDiscoverTracks(): Result<DiscoverTracksApiResponse>
}

internal data class DiscoverTracksRepository(private val discoverTracksRemoteDataSource: IDiscoverTracksRemoteDataSource) : IDiscoverTracksRepository {

    override suspend fun fetchDiscoverTracks() = discoverTracksRemoteDataSource.fetchDiscoverTracks()
}
