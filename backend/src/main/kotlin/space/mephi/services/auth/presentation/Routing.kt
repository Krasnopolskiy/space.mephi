package space.mephi.services.auth.presentation

import io.ktor.application.*
import io.ktor.routing.*
import space.mephi.services.auth.presentation.routes.*

fun Application.configureRouting() {
    routing {
        signIn()
        signUp()
    }
}