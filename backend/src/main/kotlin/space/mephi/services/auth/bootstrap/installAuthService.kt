package space.mephi.services.auth.bootstrap

import io.ktor.application.*

fun Application.installAuthService() {
    installDatabase()
}