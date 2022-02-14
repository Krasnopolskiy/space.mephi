package space.mephi

import io.ktor.application.*
import space.mephi.services.auth.plugins.configureDatabase
import space.mephi.services.auth.plugins.configureSerialization
import space.mephi.services.auth.presentation.configureRouting

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureSerialization()
    configureDatabase()
    configureRouting()
}
