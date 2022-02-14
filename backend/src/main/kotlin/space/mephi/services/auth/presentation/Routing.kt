package space.mephi.services.auth.presentation

import com.papsign.ktor.openapigen.route.path.normal.NormalOpenAPIRoute
import com.papsign.ktor.openapigen.route.tag
import space.mephi.common.SpaceTag
import space.mephi.services.auth.presentation.routes.signIn
import space.mephi.services.auth.presentation.routes.signUp

fun NormalOpenAPIRoute.authRouting() = tag(SpaceTag.Auth) {
    signIn()
    signUp()
}
