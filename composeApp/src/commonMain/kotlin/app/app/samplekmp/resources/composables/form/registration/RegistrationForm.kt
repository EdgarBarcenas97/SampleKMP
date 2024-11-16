package app.app.samplekmp.resources.composables.form.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.app.samplekmp.resources.composables.form.password.PasswordsForm
import app.app.samplekmp.resources.composables.form.personalData.PersonalDataForm

@Composable
fun RegistrationForm(
    modifier: Modifier = Modifier,
    state: RegistrationFormState = rememberRegistrationFormState(),
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        PersonalDataForm(state = state.personalData)
        PasswordsForm(state = state.passwords)
    }
}
