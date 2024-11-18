package app.app.samplekmp.app.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import app.app.samplekmp.app.home.data.TrackApiResponse
import app.app.samplekmp.core.extensions.convertToHttps
import app.app.samplekmp.core.extensions.one
import app.app.samplekmp.resources.Space40
import app.app.samplekmp.resources.Space8
import coil3.compose.AsyncImage

@Composable
fun TrackItem(
    track: TrackApiResponse,
    onClickItem: (String, String, String, String, Int) -> Unit
) = track.run {
    Row(
        horizontalArrangement = Arrangement.spacedBy(Space8),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {  onClickItem.invoke(name, posterUrl, albumName, artistName.joinToString(), numTracks)}
    ) {
        Box(
            modifier = Modifier.size(Space40)
        ) {
            AsyncImage(
                model = convertToHttps(posterUrl),
                modifier = Modifier.matchParentSize().clip(CircleShape),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }
        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = Int.one(),
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = albumName + " " + artistName.joinToString(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}
