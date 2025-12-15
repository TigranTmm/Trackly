package app.trackly.presentation.screens.sphere_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.trackly.domain.model.Task
import app.trackly.domain.use_cases.sphere_use_cases.SphereUseCases
import app.trackly.domain.use_cases.task_use_cases.TaskUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SphereViewModel @Inject constructor(
    val taskUseCases: TaskUseCases
) : ViewModel() {
    private val _sphereId = MutableStateFlow<Int?>(null)
    val sphereId = _sphereId.asStateFlow()

    val tasksList: Flow<List<Task>> =
        sphereId
            .filterNotNull()
            .flatMapLatest { id ->
                taskUseCases.getTasksBySphere(id)
            }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun getSphereId(id: Int) {
        _sphereId.value = id
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskUseCases.deleteTask(task)
        }
    }

    fun addTask(content: String, priority: Int) {
        viewModelScope.launch {
            taskUseCases.insertTask(Task(sphereId = sphereId.value!!, content = content, priority = priority))
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            taskUseCases.updateTask(task)
        }
    }
}