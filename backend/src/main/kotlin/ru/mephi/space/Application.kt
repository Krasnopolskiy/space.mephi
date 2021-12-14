package ru.mephi.space

import io.ktor.application.*
import ru.mephi.space.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureRouting()
    configureCors()
    configureSerialization()
    configureStatusPages()
}
