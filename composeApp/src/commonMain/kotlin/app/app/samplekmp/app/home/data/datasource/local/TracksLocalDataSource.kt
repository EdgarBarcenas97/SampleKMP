package app.app.samplekmp.app.home.data.datasource.local


internal class DiscoverTracksLocalDataSource(private val tracksDao: TracksDao) {

    suspend fun insertTracks(tracks: List<TrackEntity>) {
        tracksDao.insertTracks(tracks)
    }
}
