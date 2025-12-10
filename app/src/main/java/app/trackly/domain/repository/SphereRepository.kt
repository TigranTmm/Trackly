package app.trackly.domain.repository

import app.trackly.domain.model.Sphere
import kotlinx.coroutines.flow.Flow

interface SphereRepository {
    fun getAllSpheres(): Flow<List<Sphere>>

    suspend fun getSphere(id: Int?): Sphere?

    suspend fun insertSphere(sphere: Sphere)

    suspend fun deleteSphere(sphere: Sphere)

    suspend fun updateSphere(sphere: Sphere)
}