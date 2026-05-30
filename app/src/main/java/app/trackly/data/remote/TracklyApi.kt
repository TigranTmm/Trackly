package app.trackly.data.remote

import app.trackly.data.remote.dto.LoginRequestDto
import app.trackly.data.remote.dto.LoginResponseDto
import app.trackly.data.remote.dto.RegisterRequestDto
import app.trackly.data.remote.dto.RegisterResponseDto
import app.trackly.data.remote.dto.SphereRequestDto
import app.trackly.data.remote.dto.SphereResponseDto
import app.trackly.data.remote.dto.TaskRequestDto
import app.trackly.data.remote.dto.TaskResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TracklyApi @Inject constructor(
    private val client: HttpClient
) {

    /** Auth **/
    suspend fun login(request: LoginRequestDto): LoginResponseDto {
        return client.post("login") {
            setBody(request)
        }.body()
    }

    suspend fun register(request: RegisterRequestDto): RegisterResponseDto {
        return client.post("register") {
            setBody(request)
        }.body()
    }

    /** Spheres **/
    suspend fun getSpheres(): List<SphereResponseDto> {
        val response = client.get("spheres")

        return response.body()
    }

    suspend fun getSphere(id: Long): SphereResponseDto {
        val response = client.get("spheres/$id")

        return response.body()
    }

    suspend fun createSphere(request: SphereRequestDto): SphereResponseDto {
        val response = client.post("spheres") {
            setBody(request)
        }

        return response.body()
    }

    suspend fun updateSphere(
        id: Long,
        request: SphereRequestDto
    ): SphereResponseDto {
        val response = client.put("spheres/$id") {
            setBody(request)
        }

        return response.body()
    }

    suspend fun deleteSphere(id: Long) {
        client.delete("spheres/$id")
    }

    suspend fun getTasksBySphere(sphereId: Long): List<TaskResponseDto> {
        val response = client.get("spheres/$sphereId/tasks")

        return response.body()
    }

    /** Tasks **/
    suspend fun getTask(
        sphereId: Long,
        taskId: Long
    ): TaskResponseDto {
        val response = client.get("spheres/$sphereId/tasks/$taskId")

        return response.body()
    }

    suspend fun createTask(
        sphereId: Long,
        request: TaskRequestDto
    ): TaskResponseDto {
        val response = client.post("spheres/$sphereId/tasks") {
            setBody(request)
        }

        return response.body()
    }

    suspend fun updateTask(
        sphereId: Long,
        taskId: Long,
        request: TaskRequestDto
    ): TaskResponseDto {
        val response = client.put("spheres/$sphereId/tasks/$taskId") {
            setBody(request)
        }

        return response.body()
    }

    suspend fun deleteTask(
        sphereId: Long,
        taskId: Long
    ) {
        client.delete("spheres/$sphereId/tasks/$taskId")
    }
}