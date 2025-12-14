package app.trackly.presentation.screens.sphere_screen

import androidx.lifecycle.ViewModel
import app.trackly.domain.use_cases.sphere_use_cases.SphereUseCases
import app.trackly.domain.use_cases.task_use_cases.TaskUseCases
import javax.inject.Inject

class SphereViewModel @Inject constructor(
    val taskUseCases: TaskUseCases
) : ViewModel() {
}