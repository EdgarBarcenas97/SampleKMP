package app.app.samplekmp.app.profile.delete

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
data object DeleteAccountScreenRoute

@Composable
fun DeleteAccountScreen(
    onCloseClick: () -> Unit,
    onStartDeletingClick: () -> Unit
) {
    DeleteAccountScaffold(
        onCloseClick = onCloseClick,
        onStartDeletingClick = onStartDeletingClick
    )
}
