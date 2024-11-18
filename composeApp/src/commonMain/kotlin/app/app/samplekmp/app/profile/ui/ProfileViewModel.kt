package app.app.samplekmp.app.profile.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.app.samplekmp.app.profile.domain.GetUserUseCase
import app.app.samplekmp.app.profile.domain.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProfileViewModel : ViewModel(), KoinComponent {

    private val getUserDataUseCase: GetUserUseCase by inject()

    private val _profileUiModelState = MutableStateFlow(ProfileUiModelState())
    val profileUiModelState: StateFlow<ProfileUiModelState>
        get() = _profileUiModelState

    init {
        getUser()
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
