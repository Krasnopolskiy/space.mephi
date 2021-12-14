package ru.mephi.space.routes.common

import io.ktor.application.*
import io.ktor.routing.*

fun Application.commonRouter() {
    routing {
        index()
    }
}