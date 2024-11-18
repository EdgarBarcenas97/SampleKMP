package app.app.samplekmp.app.home.domain

import app.app.samplekmp.app.home.data.DiscoverTracksApiResponse
import app.app.samplekmp.app.home.data.IDiscoverTracksRepository
import app.app.samplekmp.core.result.Result

interface IFetchTrackUseCase {
    suspend fun fetchDiscoverTracks(): Result<DiscoverTracksApiResponse>
}

internal data class FetchTrackUseCase(private val discoverTracksRepository: IDiscoverTracksRepository) : IFetchTrackUseCase {

    override suspend fun fetchDiscoverTracks() = discoverTracksRepository.fetchDiscoverTracks()

}