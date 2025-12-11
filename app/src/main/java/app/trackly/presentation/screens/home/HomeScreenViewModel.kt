package app.trackly.presentation.screens.home

import androidx.lifecycle.ViewModel
import app.trackly.domain.use_cases.sphere_use_cases.SphereUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val sphereUseCases: SphereUseCases
) : ViewModel() {

}