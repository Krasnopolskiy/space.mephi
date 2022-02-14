package space.mephi.services.auth.presentation

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import space.mephi.services.auth.presentation.routes.*

fun Application.authRouting() {
    routing {
        signIn()
        signUp()
    }
}