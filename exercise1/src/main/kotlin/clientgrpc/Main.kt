
import User.UserResponse

fun main() {
    // Creamos una instancia del cliente
    val client = Client()

    // Realizamos la llamada al servicio GetUser con userId = "123"
    val response: UserResponse = client.getUser("123")

    // Imprimir la respuesta
    println("Usuario: ${response.name}, Correo: ${response.email}")

    // Cerrar la conexión al servidor gRPC
    client.shutdown()

}