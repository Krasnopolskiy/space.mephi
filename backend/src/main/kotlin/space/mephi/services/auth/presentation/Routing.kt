package space.mephi.services.auth.presentation

import com.papsign.ktor.openapigen.APITag
import com.papsign.ktor.openapigen.route.path.normal.NormalOpenAPIRoute
import com.papsign.ktor.openapigen.route.tag
import space.mephi.services.auth.presentation.routes.signIn
import space.mephi.services.auth.presentation.routes.signUp

data class AuthTag(
    override val name: String = "Authentication service",
    override val description: String = "User authorization and registration"
) : APITag

fun NormalOpenAPIRoute.authRouting() = tag(AuthTag()) {
    signIn()
    signUp()
}