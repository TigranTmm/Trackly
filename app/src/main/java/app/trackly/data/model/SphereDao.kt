package app.trackly.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import app.trackly.domain.model.Sphere
import kotlinx.coroutines.flow.Flow

@Dao
interface SphereDao {
    @Query("SELECT * FROM sphere")
    fun getAllSpheres(): Flow<List<Sphere>>

    @Query("SELECT * FROM sphere WHERE id = :id")
    suspend fun getSphere(id: Int?): Sphere?

    @Insert
    suspend fun insertSphere(sphere: Sphere)

    @Delete
    suspend fun deleteSphere(sphere: Sphere)

    @Update
    suspend fun updateSphere(sphere: Sphere)
}