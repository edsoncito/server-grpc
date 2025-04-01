import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import Users.*
import io.grpc.stub.StreamObserver

fun main() {
    val channel: ManagedChannel = ManagedChannelBuilder.forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    // Crear el stub para acceder al servicio gRPC
    val stub = UserServiceGrpc.newStub(channel)

    // Llamada al RPC de streaming ListUsers
    listUsers(stub)

    // Mantener el canal abierto para recibir los mensajes
    Thread.sleep(5000)
    channel.shutdownNow()
}

fun listUsers(stub: UserServiceGrpc.UserServiceStub) {
    val request = ListUsersRequest.newBuilder()
        .setFilter("Alice")
        .build()

    val responseObserver = object : StreamObserver<UserResponse> {
        override fun onNext(user: UserResponse) {
            println("Usuario recibido: ${user.name}, ID: ${user.userId}, Email: ${user.email}")
        }

        override fun onError(t: Throwable) {
            println("Error al recibir el stream: ${t.message}")
        }

        override fun onCompleted() {
            println("Recepción de usuarios completada.")
        }
    }

    // Realizar la llamada gRPC de streaming
    stub.listUsers(request, responseObserver)
}