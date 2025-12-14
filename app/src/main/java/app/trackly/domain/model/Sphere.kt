package app.trackly.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import app.trackly.presentation.ui.theme.Blue
import app.trackly.presentation.ui.theme.Green
import app.trackly.presentation.ui.theme.Orange
import app.trackly.presentation.ui.theme.Red
import app.trackly.presentation.ui.theme.Yellow

@Entity
data class Sphere(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val title: String,
    val color: String = "RED"
) {
    companion object {
        val primaryColors = mapOf(
            "RED" to Red,
            "ORANGE" to Orange,
            "YELLOW" to Yellow,
            "GREEN" to Green,
            "BLUE" to Blue
        )
    }
}
