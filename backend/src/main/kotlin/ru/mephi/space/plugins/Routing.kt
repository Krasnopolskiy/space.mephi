package ru.mephi.space.plugins

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import ru.mephi.space.views.signUpUser

fun Application.configureRouting() {
    routing {
        get("/") { call.respondText("Hello!") }
        post("/signup") { signUpUser() }
    }
}
