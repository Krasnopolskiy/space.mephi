package space.mephi.common.modules

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import space.mephi.services.auth.config.configureAuthStatusPages

// StatusPages are used to correctly handle exceptions
fun Application.installStatusPages() {
    install(StatusPages) {
        configureAuthStatusPages()
        exception<Exception> { cause -> // 500
            call.respond(HttpStatusCode.InternalServerError, cause.message ?: "")
        }
    }
}