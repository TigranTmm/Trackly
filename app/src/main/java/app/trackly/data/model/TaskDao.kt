package app.trackly.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import app.trackly.domain.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getTasks(): Flow<List<Task>>

    @Query("SELECT * FROM task WHERE date(timestamp / 1000, 'unixepoch') = date(:day / 1000, 'unixepoch')")
    fun getTasksByDay(day: Long): Flow<List<Task>>

    @Query("SELECT * FROM task WHERE id = :id")
    suspend fun getTask(id: Int): Task?

    @Insert
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)
}