package volantes.login

import io.grpc.Status
import io.grpc.StatusException
import volantes.grpc.login.LoginServiceImplBase
import volantes.grpc.login.LoginServiceOuterClass.*

class LoginService: LoginServiceImplBase() {

    override suspend fun login(request: LoginRequest): LoginResponse {
        if(request.login == "admin" && request.password == "admin") {
            return LoginResponse.newBuilder()
                    .setAccessToken("1")
                    .setRefreshToken("2")
                    .build()
        }
        throw StatusException(Status.UNAUTHENTICATED)
    }

}