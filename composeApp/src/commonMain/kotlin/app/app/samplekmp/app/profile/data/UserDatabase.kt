package app.app.samplekmp.app.profile.data

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_NAME = "user.db"

interface DB {
    fun clearAllTables()
}

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase(), DB {
    abstract fun userDao(): UserDao

    override fun clearAllTables() {}
}
