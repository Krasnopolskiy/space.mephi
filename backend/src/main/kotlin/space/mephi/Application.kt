package space.mephi

import io.ktor.application.*
import space.mephi.common.database.configureDatabase
import space.mephi.common.installModules
import space.mephi.openapi.openApiRouting
import space.mephi.services.auth.bootstrap.installAuthService

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureDatabase()

    installModules()

    openApiRouting()

    installAuthService()
}
