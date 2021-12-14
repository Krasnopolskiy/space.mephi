package ru.mephi.space.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<BadRequestException> { cause ->
            call.respond(HttpStatusCode.BadRequest, cause.message ?: "")
        }
    }
}