package app.app.samplekmp.resources.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import app.app.samplekmp.resources.Neutro00
import app.app.samplekmp.resources.Neutro100
import app.app.samplekmp.resources.Neutro80
import app.app.samplekmp.resources.RhealPrimary
import app.app.samplekmp.resources.RhealTertiaryDark
import app.app.samplekmp.resources.Space40

@Composable
fun GradientButton(
    title: StringResource,
    enabledButton: Boolean,
    onButtonPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val buttonBrush = if (enabledButton) {
        Brush.horizontalGradient(colors = listOf(RhealTertiaryDark, RhealPrimary))
    } else {
        Brush.horizontalGradient(colors = listOf(Neutro80, Neutro80))
    }
    Button(
        onClick = onButtonPressed,
        enabled = enabledButton,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        shape = MaterialTheme.shapes.extraLarge,
        modifier = modifier
            .background(brush = buttonBrush, shape = MaterialTheme.shapes.extraLarge)
            .height(Space40)
    ) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold,
                color = if (enabledButton) Neutro00 else Neutro100
            )
        )
    }
}
