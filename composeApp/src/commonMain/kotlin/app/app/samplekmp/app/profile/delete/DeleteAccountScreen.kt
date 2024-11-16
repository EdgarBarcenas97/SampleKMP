package app.app.samplekmp.app.profile.delete

import androidx.compose.runtime.Composable

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
