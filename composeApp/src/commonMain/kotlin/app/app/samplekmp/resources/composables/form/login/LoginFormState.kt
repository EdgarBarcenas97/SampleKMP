package app.app.samplekmp.resources.composables.form.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import app.app.samplekmp.resources.composables.form.email.EmailFieldState
import app.app.samplekmp.resources.composables.form.email.rememberEmailFieldState
import app.app.samplekmp.resources.composables.form.password.PasswordFieldState
import app.app.samplekmp.resources.composables.form.password.rememberPasswordFieldState

@Stable
class LoginFormState(
    val email: EmailFieldState,
    val password: PasswordFieldState,
) {

    val isValid: Boolean by derivedStateOf {
        email.isValid && password.isValid
    }
}

@Composable
fun rememberLoginFormState(): LoginFormState {
    val email = rememberEmailFieldState()
    val password = rememberPasswordFieldState()
    return remember {
        LoginFormState(email, password)
    }
}
