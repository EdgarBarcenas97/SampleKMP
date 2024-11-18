package app.app.samplekmp.app.home.ui.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailScaffold(
    id: Int,
    onCloseClick: () -> Unit
) {
    Text("Hola" + id)
}
