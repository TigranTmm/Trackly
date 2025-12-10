package app.trackly.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.trackly.presentation.ui.theme.BackGr
import app.trackly.presentation.ui.theme.Orange
import app.trackly.presentation.ui.theme.Red

@Entity
data class Task(
    @PrimaryKey val id: Int? = null,
    val sphereId: Int,
    val content: String,
    val priority: Int,
) {
    companion object {
        const val DEFAULT_PRIORITY = 0
        val priorityColors = listOf(BackGr, Orange, Red)
    }
}
