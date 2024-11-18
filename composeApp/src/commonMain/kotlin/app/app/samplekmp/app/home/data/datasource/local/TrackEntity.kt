package app.app.samplekmp.app.home.data.datasource.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.app.samplekmp.core.extensions.default

@Entity
data class TrackEntity(
    @PrimaryKey(autoGenerate = true)
    val trackId: Int = Int.default(),
    val albumId: Int,
    val albumName: String,
    val artistName: String,
    val featuredPosterUrl: String,
    val name: String,
    val numTracks: Int,
    val phonogramId: Int,
    val posterUrl: String,
    val urlredirec: String)