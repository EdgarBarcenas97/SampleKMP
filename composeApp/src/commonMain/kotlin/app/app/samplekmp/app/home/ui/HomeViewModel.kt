package app.app.samplekmp.app.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.app.samplekmp.app.home.domain.IFetchTrackUseCase
import app.app.samplekmp.app.profile.domain.GetUserUseCase
import app.app.samplekmp.app.profile.domain.User
import app.app.samplekmp.app.profile.ui.ProfileUiModelState
import app.app.samplekmp.core.result.success
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {

    private val fetchTrackUseCase : IFetchTrackUseCase by inject()
    private val getUserDataUseCase: GetUserUseCase by inject()

    private val _tracksModelsStateUi = MutableStateFlow(TracksModelsStateUi())

    val tracksModelsStateUi: StateFlow<TracksModelsStateUi>
        get() = _tracksModelsStateUi

    private val _profileUiModelState = MutableStateFlow(ProfileUiModelState())
    val profileUiModelState: StateFlow<ProfileUiModelState>
        get() = _profileUiModelState


    init {
        getUser()
        getTracks()
    }

    private fun getTracks() {
        viewModelScope.launch {
            val result = fetchTrackUseCase.fetchDiscoverTracks().success()
            val res = TracksUi(tracks = result?.tracks.orEmpty(), banners = result?.banners.orEmpty())
            _tracksModelsStateUi.value = TracksModelsStateUi(tracksUi = res)
        }
    }

    private fun getUser() {
        viewModelScope.launch {
            val result = getUserDataUseCase.invoke()
            getUserDataSuccess(user = result)
        }
    }

    private fun getUserDataSuccess(user: User) {
        _profileUiModelState.value = ProfileUiModelState(user = user)
    }
}
