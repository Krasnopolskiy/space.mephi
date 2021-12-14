package ru.mephi.space.plugins

import io.ktor.application.*
import ru.mephi.space.routes.authenticate.authenticateRouter
import ru.mephi.space.routes.common.commonRouter

fun Application.configureRouting() {
    authenticateRouter()
    commonRouter()
}
