package app.trackly.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.trackly.domain.model.Sphere
import app.trackly.domain.use_cases.sphere_use_cases.SphereUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
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

    private val _message = MutableSharedFlow<String>()
    val message = _message.asSharedFlow()

    fun addSphere(title: String, colorKey: String) {
        viewModelScope.launch {
            try {
                sphereUseCases.insertSphere(
                    Sphere(
                        id = 0L,
                        title = title,
                        colorKey = colorKey,
                        iconKey = "DEFAULT",
                        hasTasks = true
                    )
                )
            } catch (e: Exception) {
                _message.emit("Failed to create sphere")
            }
        }
    }

    fun deleteSphere(sphere: Sphere) {
        viewModelScope.launch {
            try {
                sphereUseCases.deleteSphere(sphere)
                _message.emit("Sphere deleted")
            } catch (e: ClientRequestException) {
                _message.emit("Failed to delete sphere")
            } catch (e: ServerResponseException) {
                _message.emit("Server error while deleting sphere")
            } catch (e: Exception) {
                _message.emit("Failed to delete sphere")
            }
        }
    }
}