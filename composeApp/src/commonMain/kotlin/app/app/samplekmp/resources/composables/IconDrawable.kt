package app.app.samplekmp.resources.composables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun IconDrawable(
    drawableId: DrawableResource,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(drawableId),
        contentDescription = null,
        modifier = modifier
    )
}

