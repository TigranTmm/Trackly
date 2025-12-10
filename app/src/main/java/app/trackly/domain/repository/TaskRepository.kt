package app.trackly.domain.repository

import app.trackly.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasks(): Flow<List<Task>>

    fun getTasksByDay(day: Long): Flow<List<Task>>

    suspend fun getTask(id: Int): Task?

    suspend fun insertTask(task: Task)

    suspend fun deleteTask(task: Task)

    suspend fun updateTask(task: Task)
}