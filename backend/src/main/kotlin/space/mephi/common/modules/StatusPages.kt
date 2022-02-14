package space.mephi.common.modules

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import space.mephi.common.exceptions.ForbiddenException

fun Application.installStatusPages() {
    install(StatusPages) {
        exception<ForbiddenException> { cause -> // 403
            call.respond(HttpStatusCode.Forbidden, cause.message ?: "")
        }
        exception<Exception> { cause -> // 500
            call.respond(HttpStatusCode.InternalServerError, cause.message ?: "")
        }
    }
}