package app.trackly.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.trackly.domain.model.Sphere
import app.trackly.domain.use_cases.sphere_use_cases.SphereUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val sphereUseCases: SphereUseCases
) : ViewModel() {
    val spheresList: Flow<List<Sphere>> = sphereUseCases.getAllSpheres()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )


    fun addSphere(title: String, color: String) {
        viewModelScope.launch {
            sphereUseCases.insertSphere(Sphere(title = title, color = color))
        }
    }

    fun deleteSphere(sphere: Sphere) {
        viewModelScope.launch {
            sphereUseCases.deleteSphere(sphere)
        }
    }
}