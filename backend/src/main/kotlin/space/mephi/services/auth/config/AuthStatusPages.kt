package space.mephi.services.auth.config

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*


class ForbiddenException(message: String?, cause: Throwable? = null) : Exception(message, cause)
class AlreadyExistsException(message: String?, cause: Throwable? = null) : Exception(message, cause)

fun StatusPages.Configuration.configureAuthStatusPages() {
    exception<ForbiddenException> { cause -> // 400
        call.respond(HttpStatusCode.BadRequest, cause.message ?: "")
    }
    exception<AlreadyExistsException> { cause -> // 409
        call.respond(HttpStatusCode.Conflict, cause.message ?: "")
    }
}