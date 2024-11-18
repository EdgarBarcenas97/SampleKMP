package app.app.samplekmp.app.auth.onboarding

import androidx.lifecycle.ViewModel
import app.app.samplekmp.app.auth.data.INIT_SESSION_KEY
import app.app.samplekmp.app.auth.data.LOGIN_KEY
import app.app.samplekmp.app.auth.data.PASSWORD_KEY
import app.app.samplekmp.core.extensions.empty
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OnboardingViewModel : ViewModel() {

    private val settings: Settings = Settings()

    private val _isInitSessionUiState = MutableStateFlow(false)
    val isInitSessionUiState: StateFlow<Boolean> = _isInitSessionUiState

    init {
        _isInitSessionUiState.value = settings.getBoolean(INIT_SESSION_KEY, false)
        settings[LOGIN_KEY] = "speedymovil"
        settings[PASSWORD_KEY] = "speedymovil2024"
    }
}
