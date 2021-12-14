package ru.mephi.space.routes.authenticate

import io.ktor.application.*
import io.ktor.routing.*

fun Application.authenticateRouter() {
    routing {
        signIn()
        signUp()
        signOut()
    }
}