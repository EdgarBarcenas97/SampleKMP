package app.app.samplekmp.resources.composables.form.registration

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import app.app.samplekmp.resources.composables.form.password.PasswordsFormState
import app.app.samplekmp.resources.composables.form.password.rememberNewPasswordFormState
import app.app.samplekmp.resources.composables.form.personalData.PersonalDataFormState
import app.app.samplekmp.resources.composables.form.personalData.rememberPersonalDataFormState

@Stable
class RegistrationFormState(
    val personalData: PersonalDataFormState,
    val passwords: PasswordsFormState
) {

    val isValid: Boolean by derivedStateOf {
        personalData.isValid && passwords.isValid
    }
}

@Composable
fun rememberRegistrationFormState(): RegistrationFormState {
    val personalData = rememberPersonalDataFormState()
    val newPasswordFormState = rememberNewPasswordFormState()

    return remember(personalData, newPasswordFormState) {
        RegistrationFormState(personalData, newPasswordFormState)
    }
}
