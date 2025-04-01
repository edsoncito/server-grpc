import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import Users.*
class GrpcClient {

    private val channel: ManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    private val stub: UserServiceGrpc.UserServiceBlockingStub = UserServiceGrpc.newBlockingStub(channel)

    fun getUser(userId: String): UserResponse {
        val request = GetUserRequest.newBuilder()
            .setUserId(userId)
            .build()
        return stub.getUser(request)
    }

    fun shutdown() {
        channel.shutdown()
    }
}