package app.app.samplekmp.resources.composables.form.password

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import samplekmp.composeapp.generated.resources.Res
import samplekmp.composeapp.generated.resources.password
import samplekmp.composeapp.generated.resources.repeat_password

@Composable
fun PasswordsForm(
    modifier: Modifier = Modifier,
    state: PasswordsFormState = rememberNewPasswordFormState(),
    firstLabel: String = stringResource(Res.string.password),
    secondLabel: String = stringResource(Res.string.repeat_password)
) {
    Column(modifier = modifier) {
        PasswordField(state = state.firstPassword, label = firstLabel)
        Spacer(modifier = Modifier.height(24.dp))
        PasswordField(state = state.secondPassword, label = secondLabel)
    }
}