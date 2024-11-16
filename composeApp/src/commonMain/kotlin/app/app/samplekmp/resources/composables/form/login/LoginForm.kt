package app.app.samplekmp.resources.composables.form.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.app.samplekmp.resources.composables.form.password.PasswordField
import app.app.samplekmp.resources.composables.form.email.EmailField

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    state: LoginFormState = rememberLoginFormState()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        EmailField(state = state.email)
        PasswordField(state = state.password)
    }
}
