package space.mephi.services.auth.presentation.routes

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import space.mephi.services.auth.domain.controllers.CredentialsControllerImpl
import space.mephi.services.auth.domain.dto.RawCredentials

fun Route.signIn() {
    post("signin/") {
        val credentials = call.receive<RawCredentials>()
        CredentialsControllerImpl.signin(credentials)
        call.respond("Signed in")
    }
}