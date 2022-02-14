package space.mephi

import com.papsign.ktor.openapigen.route.apiRouting
import io.ktor.application.*
import space.mephi.common.installModules
import space.mephi.openapi.openApiRouting
import space.mephi.services.auth.config.configureAuthService
import space.mephi.services.auth.presentation.authRouting

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    installModules()
    configureAuthService()
    openApiRouting()
    apiRouting {
        authRouting()
    }
}
