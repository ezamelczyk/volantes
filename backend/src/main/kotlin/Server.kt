import io.grpc.ServerBuilder
import volantes.login.LoginService

class Server(private val port: Int = 50051, private val serverBuilder: ServerBuilder<*> = ServerBuilder.forPort(port)) {
    private lateinit var server: io.grpc.Server

    fun start() {
        server = serverBuilder
                .addService(LoginService())
                .build()
                .start()
    }

    @Throws(InterruptedException::class)
    fun blockUntilShutdown() {
        server.awaitTermination()
    }

    fun stop() {
        if (::server.isInitialized)
            server.shutdown()
    }

    companion object {

        @JvmStatic
        fun main(vararg args: String) {
            val server = Server()
            server.start()
            server.blockUntilShutdown()
        }

    }
}