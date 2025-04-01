
import io.grpc.Server
import io.grpc.ServerBuilder

fun main() {
    val server: Server = ServerBuilder
        .forPort(50051)
        .addService(UserServiceImpl())
        .build()

    println("🚀 Servidor gRPC iniciado en el puerto 50051")

    server.start()
    server.awaitTermination()
}