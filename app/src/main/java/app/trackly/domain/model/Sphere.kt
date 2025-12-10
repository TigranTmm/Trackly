package app.trackly.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.trackly.presentation.ui.theme.Blue
import app.trackly.presentation.ui.theme.Green
import app.trackly.presentation.ui.theme.Orange
import app.trackly.presentation.ui.theme.Red
import app.trackly.presentation.ui.theme.Yellow

@Entity
data class Sphere(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val timeTrackingSystem: Boolean
) {
    companion object {
        const val DEFAULT_TTS = false
        val primaryColors = listOf(Red, Orange, Yellow, Green, Blue)
    }
}
