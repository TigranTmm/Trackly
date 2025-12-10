package app.trackly.data.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import app.trackly.domain.model.Task

@Database (entities = [Task::class], version = 1)
abstract class TracklyDataBase : RoomDatabase() {
    abstract val taskDao: TaskDao
}