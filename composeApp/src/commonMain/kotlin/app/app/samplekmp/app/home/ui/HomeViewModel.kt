package app.app.samplekmp.app.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.app.samplekmp.app.home.data.DiscoverTracksApiResponse
import app.app.samplekmp.app.home.domain.IFetchTrackUseCase
import app.app.samplekmp.core.result.success
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {

    private val fetchTrackUseCase : IFetchTrackUseCase by inject()

    private val _tracksModelsStateUi = MutableStateFlow(TracksModelsStateUi())

    val tracksModelsStateUi: StateFlow<TracksModelsStateUi>
        get() = _tracksModelsStateUi

    init {
        getTracks()
    }

    private fun getTracks() {
        viewModelScope.launch {
            val result = fetchTrackUseCase.fetchDiscoverTracks().success()
            val res = TracksUi(tracks = result?.tracks.orEmpty(), banners = result?.banners.orEmpty())
            _tracksModelsStateUi.value = TracksModelsStateUi(tracksUi = res)
        }
    }
}
