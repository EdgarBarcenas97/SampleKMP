package app.app.samplekmp.app.auth.signIn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.app.samplekmp.app.auth.data.LOGIN_KEY
import app.app.samplekmp.app.auth.data.PASSWORD_KEY
import app.app.samplekmp.app.profile.domain.InsertUserUseCase
import app.app.samplekmp.core.extensions.empty
import app.app.samplekmp.resources.composables.form.personalData.PersonalData
import com.russhwolf.settings.Settings
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SignInViewModel : ViewModel(), KoinComponent {

    private val insertUserUseCase: InsertUserUseCase by inject()

    private val settings: Settings = Settings()

    var isNavigate: Boolean by mutableStateOf(false)
        private set

    var user = String.empty()
    var password = String.empty()

    init{
        getUser()
    }

    private fun getUser() {
        user = settings.getString(LOGIN_KEY, String.empty())
        password = settings.getString(PASSWORD_KEY, String.empty())
    }

    fun login(email: String, password: String) {
        if (user == email && this.password == password) {
            viewModelScope.launch {
                val personalData = PersonalData(firstName = "Daniel", lastName ="Barcenas", email = "speedymovil", phoneNumber = "2281032147")
                insertUserUseCase.invoke(personalData, password)
            }
            isNavigate = true
        }
    }
}
