package app.app.samplekmp.app.home.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DiscoverTracksApiResponse(
    @SerialName("banners")
    val banners: List<BannerApiResponse>,
    @SerialName("codigoRespuesta")
    val codigoRespuesta: Int,
    @SerialName("mensajeRespuesta")
    val mensajeRespuesta: String,
    @SerialName("tracks")
    val tracks: List<TrackApiResponse>)

@Serializable
data class TrackApiResponse(
    @SerialName("albumId")
    val albumId: Int,
    @SerialName("albumName")
    val albumName: String,
    @SerialName("artistName")
    val artistName: List<String>,
    @SerialName("featuredPosterUrl")
    val featuredPosterUrl: String,
    @SerialName("name")
    val name: String,
    @SerialName("numTracks")
    val numTracks: Int,
    @SerialName("phonogramId")
    val phonogramId: Int,
    @SerialName("posterUrl")
    val posterUrl: String,
    @SerialName("urlredirec")
    val urlredirec: String)

@Serializable
data class BannerApiResponse(
    @SerialName("albumId")
    val albumId: String,
    @SerialName("albumName")
    val albumName: String,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("urlRedirect")
    val urlRedirect: String)
