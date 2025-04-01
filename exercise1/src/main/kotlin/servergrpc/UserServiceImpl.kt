
import io.grpc.stub.StreamObserver
import User.*

class UserServiceImpl : UserServiceGrpc.UserServiceImplBase() {
    override fun getUser(request: GetUserRequest, responseObserver: StreamObserver<UserResponse>) {
        val userResponse = UserResponse.newBuilder()
            .setUserId(request.userId)
            .setName("Alice")
            .setEmail("alice@example.com")
            .build()

        responseObserver.onNext(userResponse)
        responseObserver.onCompleted()
    }
}