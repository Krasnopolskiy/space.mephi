package ru.mephi.space.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*

fun Application.configureCors() {
    install(CORS) {
        header(HttpHeaders.ContentType)
    }
}