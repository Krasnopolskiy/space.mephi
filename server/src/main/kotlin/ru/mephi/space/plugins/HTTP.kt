package ru.mephi.space.plugins

import io.ktor.http.*
import io.ktor.features.*
import io.ktor.application.*

fun Application.configureHTTP() {
    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header("MyCustomHeader")
        allowCredentials = true
    }
}
