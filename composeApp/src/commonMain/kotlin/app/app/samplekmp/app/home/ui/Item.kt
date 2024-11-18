package app.app.samplekmp.app.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import app.app.samplekmp.resources.Space16
import app.app.samplekmp.resources.Space4
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import app.app.samplekmp.app.home.data.TrackApiResponse

@Composable
fun ChatItem(track: TrackApiResponse) = track.run {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Space4)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 48f, topEnd = 48f))
                .padding(Space16)
        ) {
            Text(text = albumName)
        }
    }
}
