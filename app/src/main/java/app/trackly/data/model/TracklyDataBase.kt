package app.trackly.data.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import app.trackly.domain.model.Sphere
import app.trackly.domain.model.Task

val MIGRATION_3_4 = Migration(3, 4) { /* SQL для изменений от 3 к 4 */ }
val MIGRATION_4_5 = Migration(4, 5) { /* ... */ }
val MIGRATION_5_6 = Migration(5, 6) { /* ... */ }

@Database (entities = [Task::class, Sphere::class], version = 6, exportSchema = false)
abstract class TracklyDataBase : RoomDatabase() {
    abstract val taskDao: TaskDao
    abstract val sphereDao: SphereDao

    companion object {
        const val DATABASE_NAME = "trackly_db"
    }
}