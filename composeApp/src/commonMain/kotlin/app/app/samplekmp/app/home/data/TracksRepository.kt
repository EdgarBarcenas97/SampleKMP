package app.app.samplekmp.app.home.data

import app.app.samplekmp.app.home.data.datasource.local.DiscoverTracksLocalDataSource
import app.app.samplekmp.app.home.data.datasource.remote.DiscoverTracksApiResponse
import app.app.samplekmp.app.home.data.datasource.remote.IDiscoverTracksRemoteDataSource
import app.app.samplekmp.app.home.data.datasource.remote.toTrackListEntity
import app.app.samplekmp.core.result.Result

internal interface IDiscoverTracksRepository {
    suspend fun fetchDiscoverTracks(): Result<DiscoverTracksApiResponse>
}

internal data class DiscoverTracksRepository(
    private val discoverTracksRemoteDataSource: IDiscoverTracksRemoteDataSource,
    private val discoverTracksLocalDataSource: DiscoverTracksLocalDataSource
) : IDiscoverTracksRepository {

    override suspend fun fetchDiscoverTracks(): Result<DiscoverTracksApiResponse> {
        val result = discoverTracksRemoteDataSource.fetchDiscoverTracks()
        if (result is Result.Success) {
            discoverTracksLocalDataSource.insertTracks(result.value.tracks.toTrackListEntity())
        }
        return result
    }
}
