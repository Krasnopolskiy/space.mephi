package ru.mephi.space.routes.authenticate

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.signIn() {
    post("/signin") { call.respond("signed in") }
}