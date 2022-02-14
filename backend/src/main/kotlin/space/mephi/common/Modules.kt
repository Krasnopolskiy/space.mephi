package space.mephi.common

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*
import space.mephi.common.modules.installOpenAPIGen
import space.mephi.common.modules.installStatusPages

fun Application.installModules() {
    install(ContentNegotiation) { jackson() }
    installStatusPages()
    installOpenAPIGen()
}