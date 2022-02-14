package space.mephi.services.auth.presentation.routes

import com.papsign.ktor.openapigen.route.info
import com.papsign.ktor.openapigen.route.path.normal.NormalOpenAPIRoute
import com.papsign.ktor.openapigen.route.path.normal.post
import com.papsign.ktor.openapigen.route.response.respond
import com.papsign.ktor.openapigen.route.route
import space.mephi.services.auth.domain.controllers.CredentialsControllerImpl
import space.mephi.services.auth.domain.dto.RawCredentials

fun NormalOpenAPIRoute.signUp() {
    route("signup") {
        post<String, String, RawCredentials>(
            info("Sing up")
        ) { _, rawCredentials ->
            CredentialsControllerImpl.signup(rawCredentials)
            respond("Signed Un")
        }
    }
}