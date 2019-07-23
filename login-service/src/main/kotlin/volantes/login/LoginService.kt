package volantes.login

import volantes.grpc.login.LoginServiceImplBase
import volantes.grpc.login.LoginServiceOuterClass
import kotlin.coroutines.CoroutineContext

class LoginService(override val coroutineContext: CoroutineContext): LoginServiceImplBase() {

    override suspend fun login(request: LoginServiceOuterClass.LoginRequest): LoginServiceOuterClass.LoginResponse {
        if(request.login == "admin" && request.password == "admin") {
            return LoginServiceOuterClass.LoginResponse.newBuilder()
                    .setAccessToken("1")
                    .setRefreshToken("2")
                    .build()
        }
    }

}