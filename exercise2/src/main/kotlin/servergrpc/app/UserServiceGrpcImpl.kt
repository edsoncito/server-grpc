package servergrpc.app
import UserServiceGrpc
import io.grpc.stub.StreamObserver
import Users.*
import servergrpc.domain.IUserService

class UserServiceGrpcImpl(private val userService: IUserService) : UserServiceGrpc.UserServiceImplBase() {

    override fun getUser(request: GetUserRequest, responseObserver: StreamObserver<UserResponse>) {
        try {
            val user = userService.getUserById(request.userId)
            responseObserver.onNext(user)
            responseObserver.onCompleted()
        } catch (e: Exception) {
            responseObserver.onError(e)
        }
    }

    override fun listUsers(request: ListUsersRequest, responseObserver: StreamObserver<UserResponse>) {
        try {
            val users = userService.listUsers(request.filter)
            users.forEach { responseObserver.onNext(it) }
            responseObserver.onCompleted()
        } catch (e: Exception) {
            responseObserver.onError(e)
        }
    }
}