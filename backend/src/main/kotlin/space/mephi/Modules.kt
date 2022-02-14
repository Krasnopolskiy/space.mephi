package space.mephi

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*

fun Application.installModules() {
    install(ContentNegotiation) {
        jackson()
    }
}