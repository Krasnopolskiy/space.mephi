package space.mephi.services.auth.bootstrap

import com.papsign.ktor.openapigen.route.apiRouting
import io.ktor.application.*
import space.mephi.services.auth.presentation.authRouting

fun Application.installAuthService() {
    installDatabase()
    apiRouting {
        authRouting()
    }
}