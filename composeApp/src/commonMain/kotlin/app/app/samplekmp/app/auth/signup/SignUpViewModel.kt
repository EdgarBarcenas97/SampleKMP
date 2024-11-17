package app.app.samplekmp.app.auth.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.app.samplekmp.app.auth.data.INIT_SESSION_KEY
import app.app.samplekmp.app.profile.domain.InsertUserUseCase
import com.russhwolf.settings.Settings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SignUpViewModel : ViewModel(), KoinComponent {

    private val insertUserUseCase: InsertUserUseCase by inject()

    private val settings: Settings = Settings()

    private val _createProfileUiState = MutableStateFlow(SignUpProfileUiState())
    val createProfileUiState: StateFlow<SignUpProfileUiState> = _createProfileUiState

    fun setInitialData() {
        viewModelScope.launch {
            settings.putBoolean(INIT_SESSION_KEY, true)
            insertUserUseCase()
        }
    }
}
