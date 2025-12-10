package app.trackly.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.trackly.presentation.ui.theme.BackGr
import app.trackly.presentation.ui.theme.Orange
import app.trackly.presentation.ui.theme.Red

@Entity
data class Task(
    @PrimaryKey val id: Int? = null,
    val content: String,
    val priority: Int,
    val timestamp: Long
) {
    companion object {
        const val DEFAULT_PRIORITY = 0
        val priorityColors = listOf(BackGr, Orange, Red)
    }
}
