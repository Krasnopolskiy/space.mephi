package space.mephi.services.auth.presentation

import com.papsign.ktor.openapigen.APITag
import com.papsign.ktor.openapigen.route.path.normal.NormalOpenAPIRoute
import com.papsign.ktor.openapigen.route.tag
import space.mephi.services.auth.presentation.routes.signIn
import space.mephi.services.auth.presentation.routes.signUp

enum class AuthTag(override val description: String) : APITag {
    Auth("Authentication")
}

fun NormalOpenAPIRoute.authRouting() = tag(AuthTag.Auth) {
    signIn()
    signUp()
}
