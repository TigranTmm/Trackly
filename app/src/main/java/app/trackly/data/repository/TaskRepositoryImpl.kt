package app.trackly.data.repository

import app.trackly.data.model.TaskDao
import app.trackly.domain.model.Task
import app.trackly.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    private val dao: TaskDao
) : TaskRepository {
    override fun getTasks(): Flow<List<Task>> {
        return dao.getTasks()
    }

    override fun getTasksByDay(day: Long): Flow<List<Task>> {
        return dao.getTasksByDay(day)
    }

    override suspend fun getTask(id: Int): Task? {
        return dao.getTask(id)
    }

    override suspend fun insertTask(task: Task) {
        dao.insertTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        dao.deleteTask(task)
    }

    override suspend fun updateTask(task: Task) {
        dao.updateTask(task)
    }
}