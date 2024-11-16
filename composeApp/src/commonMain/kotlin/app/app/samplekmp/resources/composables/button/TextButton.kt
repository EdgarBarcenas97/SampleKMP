package app.app.samplekmp.resources.composables.button

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import app.app.samplekmp.resources.RhealQuaternary
import app.app.samplekmp.resources.Space8
import app.app.samplekmp.resources.body

@Composable
fun TextButton(
    title: StringResource,
    onTextButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onTextButtonClick,
        shape = MaterialTheme.shapes.extraLarge,
        colors =  ButtonColors (
            containerColor = Color.Transparent,
            contentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        ),
        modifier = modifier.padding(Space8)
    ) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.labelMedium.copy(
                fontSize = body,
                fontWeight = FontWeight.SemiBold,
                color = RhealQuaternary,
                textAlign = TextAlign.Center
            )
        )
    }
}
