package app.app.samplekmp.app.auth.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.app.samplekmp.app.auth.data.INIT_SESSION_KEY
import app.app.samplekmp.app.profile.domain.InsertUserUseCase
import app.app.samplekmp.resources.composables.form.personalData.PersonalData
import com.russhwolf.settings.Settings
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SignUpViewModel : ViewModel(), KoinComponent {

    private val insertUserUseCase: InsertUserUseCase by inject()

    private val settings: Settings = Settings()

    fun signup(personalData: PersonalData, password: String) {
        viewModelScope.launch {
            settings.putBoolean(INIT_SESSION_KEY, true)
            insertUserUseCase.invoke(personalData, password)
        }
    }
}
