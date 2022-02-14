package space.mephi

import io.ktor.application.*
import space.mephi.services.auth.config.configureAuth
import space.mephi.services.auth.presentation.authRouting

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    installModules()
    configureAuth()
    authRouting()
}
