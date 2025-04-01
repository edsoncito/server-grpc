
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder

class Client {

    private val channel: ManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    private val stub: UserServiceGrpc.UserServiceBlockingStub = UserServiceGrpc.newBlockingStub(channel)

    fun getUser(userId: String): User.UserResponse {
        val request = User.GetUserRequest.newBuilder()
            .setUserId(userId)
            .build()
        return stub.getUser(request)
    }

    fun shutdown() {
        channel.shutdown()
    }
}