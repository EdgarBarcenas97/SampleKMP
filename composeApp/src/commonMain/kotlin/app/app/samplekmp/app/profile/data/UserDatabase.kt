package app.app.samplekmp.app.profile.data

import androidx.room.Database
import androidx.room.RoomDatabase
import app.app.samplekmp.app.home.data.datasource.local.TrackEntity
import app.app.samplekmp.app.home.data.datasource.local.TracksDao

const val DATABASE_NAME = "user.db"

interface DB {
    fun clearAllTables()
}

@Database(entities = [UserEntity::class, TrackEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase(), DB {
    abstract fun userDao(): UserDao

    abstract fun trackDao(): TracksDao

    override fun clearAllTables() {}
}
