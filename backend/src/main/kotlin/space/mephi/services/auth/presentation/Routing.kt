package space.mephi.services.auth.presentation

import io.ktor.application.*
import io.ktor.routing.*
import space.mephi.services.auth.presentation.routes.signIn
import space.mephi.services.auth.presentation.routes.signUp

fun Application.authRouting() {
    routing {
        signIn()
        signUp()
    }
}