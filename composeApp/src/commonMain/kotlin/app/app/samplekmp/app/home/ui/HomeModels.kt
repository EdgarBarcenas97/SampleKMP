package app.app.samplekmp.app.home.ui

import app.app.samplekmp.app.home.data.BannerApiResponse
import app.app.samplekmp.app.home.data.TrackApiResponse

data class TracksUi(val banners: List<BannerApiResponse>,
                    val tracks: List<TrackApiResponse>)

data class TracksModelsStateUi(val isLoading: Boolean = false,
                               val tracksUi: TracksUi? = null,
                               val error: Exception? = null)
