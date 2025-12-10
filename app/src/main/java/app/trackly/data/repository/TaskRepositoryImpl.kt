package app.trackly.data.repository

import app.trackly.data.model.TaskDao
import app.trackly.domain.model.Task
import app.trackly.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    private val dao: TaskDao
) : TaskRepository {
    override fun getAllTasks(): Flow<List<Task>> {
        return dao.getAllTasks()
    }

    override fun getTasksBySphere(sphereId: Int): Flow<List<Task>> {
        return dao.getTasksBySphere(sphereId)
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