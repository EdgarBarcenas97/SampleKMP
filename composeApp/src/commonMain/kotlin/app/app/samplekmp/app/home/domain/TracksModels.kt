package app.app.samplekmp.app.home.domain

data class Tracks(
    val banners: List<Banner>,
    val codigoRespuesta: Int,
    val mensajeRespuesta: String,
    val tracks: List<Track>)

data class Track(
    val albumId: Int,
    val albumName: String,
    val artistName: List<String>,
    val featuredPosterUrl: String,
    val name: String,
    val numTracks: Int,
    val phonogramId: Int,
    val posterUrl: String,
    val urlredirec: String)

data class Banner(
    val albumId: String,
    val albumName: String,
    val id: Int,
    val image: String,
    val urlRedirect: String)