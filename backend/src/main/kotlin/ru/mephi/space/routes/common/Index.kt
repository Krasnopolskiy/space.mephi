package ru.mephi.space.routes.common

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.index() {
    get("/") { call.respond("Hello") }
}