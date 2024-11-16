package app.app.samplekmp.app.auth.signup

import androidx.compose.runtime.Composable
import app.app.samplekmp.resources.composables.form.personalData.PersonalData

@Composable
fun SignUpScreen(
    onBackClick: () -> Unit,
    onRegisterClick: (personalData: PersonalData, password: String) -> Unit
) {
    SignUpScaffold(
        onBackClick = onBackClick,
        onRegisterClick = onRegisterClick
    )
}
