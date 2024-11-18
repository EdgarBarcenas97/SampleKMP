package app.app.samplekmp.app.home.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TracksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTracks(trackEntity: List<TrackEntity>)

    @Query("SELECT * FROM TrackEntity")
    suspend fun getTracks(): TrackEntity

    @Query("SELECT * FROM TrackEntity")
    fun getTracksFlow(): Flow<List<TrackEntity>>

    @Query("DELETE FROM TrackEntity")
    suspend fun deleteTracks()
}
