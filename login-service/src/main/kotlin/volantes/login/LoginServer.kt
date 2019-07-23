package volantes.login

import io.grpc.Server
import io.grpc.ServerBuilder

class LoginServer(private val port: Int = 50051, private val serverBuilder: ServerBuilder<*> = ServerBuilder.forPort(port)) {
    private lateinit var server: Server

    fun start() {
        server = serverBuilder
                .addService(LoginService())
                .build()
                .start()
        println("Login server started")
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
            val server = LoginServer()
            server.start()
            server.blockUntilShutdown()
        }

    }
}