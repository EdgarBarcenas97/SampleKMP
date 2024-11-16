package app.app.samplekmp.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import app.app.samplekmp.app.profile.data.DATABASE_NAME
import app.app.samplekmp.app.profile.data.UserDatabase
import app.app.samplekmp.app.profile.data.instantiateImpl
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): RoomDatabase.Builder<UserDatabase> {
    val dbFilePath = NSHomeDirectory() + "/Documents/$DATABASE_NAME"
    return Room.databaseBuilder<UserDatabase>(
        name = dbFilePath,
        factory = { UserDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
}
