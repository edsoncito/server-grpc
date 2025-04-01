package servergrpc.domain
import Users.UserResponse

interface IUserService {
    fun getUserById(userId: String): UserResponse
    fun listUsers(filter: String): List<UserResponse>
}