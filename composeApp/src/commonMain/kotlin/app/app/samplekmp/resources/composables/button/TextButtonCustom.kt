package app.app.samplekmp.resources.composables.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TextButtonCustom(
    title: StringResource,
    onTextButtonClick: () -> Unit,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onTextButtonClick,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.textButtonColors(contentColor = color)
    ) {
        Text(text = stringResource(title))
    }
}
