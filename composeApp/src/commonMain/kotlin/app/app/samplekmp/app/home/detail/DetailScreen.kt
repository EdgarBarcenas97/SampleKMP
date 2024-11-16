package app.app.samplekmp.app.home.detail

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
data object DetailScreenRoute

@Composable
fun DetailScreen(
    onCloseClick: () -> Unit,
) {
    DetailScaffold(
        onCloseClick = onCloseClick,
    )
}
