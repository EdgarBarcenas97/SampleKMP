package app.app.samplekmp.app.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.app.samplekmp.app.home.domain.IFetchTrackUseCase
import app.app.samplekmp.core.result.success
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {

    private val fetchTrackUseCase : IFetchTrackUseCase by inject()

    init {
        getTracks()
    }

    private fun getTracks() {
        viewModelScope.launch {
            val result = fetchTrackUseCase.fetchDiscoverTracks().success()
            val tracks = result?.tracks
        }
    }
}
