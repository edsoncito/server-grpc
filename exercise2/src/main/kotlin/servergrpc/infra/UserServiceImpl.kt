package servergrpc.infra

import Users.*
import servergrpc.domain.IUserService

class UserServiceImpl : IUserService {

    override fun getUserById(userId: String): UserResponse {
        // Simulación de la obtención del usuario (esto debería provenir de una base de datos o fuente externa)
        return UserResponse.newBuilder()
            .setUserId(userId)
            .setName("Alice")
            .setEmail("alice@example.com")
            .build()
    }

    override fun listUsers(filter: String): List<UserResponse> {
        // Simulación de una lista de usuarios
        val users = listOf(
            UserResponse.newBuilder().setUserId("1").setName("Alice").setEmail("alice@example.com").build(),
            UserResponse.newBuilder().setUserId("2").setName("Bob").setEmail("bob@example.com").build(),
            UserResponse.newBuilder().setUserId("3").setName("Charlie").setEmail("charlie@example.com").build()
        )

        // Filtrar los usuarios según el filtro (si se aplica)
        return if (filter.isNotEmpty()) {
            users.filter { it.name.contains(filter, ignoreCase = true) }
        } else {
            users
        }
    }
}