package app.app.samplekmp.app.home.ui.detail

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
data class DetailScreenRoute(val name: String,
                             val posterUrl: String,
                             val albumName: String,
                             val artistName: String,
                             val numTracks: Int)

@Composable
fun DetailScreen(
    name: String,
    posterUrl: String,
    albumName: String,
    artistName: String,
    numTracks: Int,
    onCloseClick: () -> Unit,
) {
    DetailScaffold(
        name = name,
        posterUrl = posterUrl,
        albumName = albumName,
        artistName = artistName,
        numTracks = numTracks,
        onCloseClick = onCloseClick
    )
}
