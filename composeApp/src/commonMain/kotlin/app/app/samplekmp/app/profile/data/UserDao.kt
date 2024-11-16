package app.app.samplekmp.app.profile.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM UserEntity")
    suspend fun getUser(): UserEntity

    @Query("SELECT * FROM UserEntity")
    fun getUserFlow(): Flow<List<UserEntity>>

    @Query("DELETE FROM UserEntity")
    suspend fun deleteUser()
}
