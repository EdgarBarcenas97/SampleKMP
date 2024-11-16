package app.app.samplekmp.resources.composables.form.password

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import org.jetbrains.compose.resources.stringResource
import samplekmp.composeapp.generated.resources.Res
import samplekmp.composeapp.generated.resources.password

@Composable
fun PasswordField(
    modifier: Modifier = Modifier,
    state: PasswordFieldState = rememberPasswordFieldState(),
    label: String = stringResource(Res.string.password),
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = state.value,
        onValueChange = state::onValueChanged,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Password, contentDescription = null)
        },
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(
                    imageVector = if (isPasswordVisible) {
                        Icons.Default.Visibility
                    } else {
                        Icons.Default.VisibilityOff
                    },
                    contentDescription = null
                )
            }
        },
        visualTransformation = if (isPasswordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        isError = state.error != null,
        supportingText = state.error?.let {
            {
                Text(text = it, style = MaterialTheme.typography.bodySmall, color = Color.Red)
            }
        }
    )
}
