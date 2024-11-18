package app.app.samplekmp.app.home.ui.detail

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
data class DetailScreenRoute(val id: Int)

@Composable
fun DetailScreen(
    id: Int,
    onCloseClick: () -> Unit,
) {
    DetailScaffold(
        id = id,
        onCloseClick = onCloseClick,
    )
}
