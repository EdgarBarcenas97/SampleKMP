package app.app.samplekmp.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import app.app.samplekmp.app.profile.data.DATABASE_NAME
import app.app.samplekmp.app.profile.data.UserDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<UserDatabase> {

    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath(DATABASE_NAME)
    return Room.databaseBuilder(
        context = appContext,
        name = dbFile.absolutePath
    )
}
