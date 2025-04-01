import io.grpc.Server
import io.grpc.ServerBuilder
import servergrpc.app.UserServiceGrpcImpl
import servergrpc.infra.UserServiceImpl

fun main() {
    // Inicializar el servicio de negocio
    val userService = UserServiceImpl()

    // Inicializar el servicio gRPC que delega al servicio de negocio
    val userServiceGrpc = UserServiceGrpcImpl(userService)

    // Configurar y arrancar el servidor gRPC
    val server: Server = ServerBuilder.forPort(50051)
        .addService(userServiceGrpc)
        .build()

    println("Servidor gRPC en ejecución en el puerto 50051...")
    server.start()
    server.awaitTermination()
}