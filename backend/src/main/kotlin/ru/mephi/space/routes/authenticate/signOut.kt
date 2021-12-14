package ru.mephi.space.routes.authenticate

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.signOut() {
    get("/signout") { call.respond("signed out") }
}