package app.trackly.data.repository

import app.trackly.data.model.SphereDao
import app.trackly.domain.model.Sphere
import app.trackly.domain.repository.SphereRepository
import kotlinx.coroutines.flow.Flow

class SphereRepositoryImpl(
    private val dao: SphereDao
) : SphereRepository {
    override fun getAllSpheres(): Flow<List<Sphere>> {
        return dao.getAllSpheres()
    }

    override suspend fun getSphere(id: Int?): Sphere? {
        return dao.getSphere(id)
    }

    override suspend fun insertSphere(sphere: Sphere) {
        dao.insertSphere(sphere)
    }

    override suspend fun deleteSphere(sphere: Sphere) {
        dao.deleteSphere(sphere)
    }

    override suspend fun updateSphere(sphere: Sphere) {
        dao.updateSphere(sphere)
    }
}