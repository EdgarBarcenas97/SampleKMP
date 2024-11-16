package app.app.samplekmp.resources.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction

@Composable
fun TextField(
    label: String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    state: TextFieldState = rememberTextFieldState()
) {
    OutlinedTextField(
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {}),
        value = state.value,
        onValueChange = { state.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        label = {
            Text(text = label)
        },
        leadingIcon = icon?.let {
            {
                Icon(imageVector = icon, contentDescription = null)
            }
        }
    )
}
