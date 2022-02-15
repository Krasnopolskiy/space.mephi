package space.mephi.openapi

import com.papsign.ktor.openapigen.OpenAPIGen
import io.ktor.application.*

fun Application.installOpenAPIGen() {
    install(OpenAPIGen) {
        val host = environment.config.property("ktor.deployment.host").getString()
        val port = environment.config.property("ktor.deployment.port").getString()

        info {
            version = environment.config.property("openapi.version").getString()
            title = environment.config.property("openapi.title").getString()
            description = environment.config.property("openapi.description").getString()
        }

        server("http://$host:$port/") {
            description = environment.config.property("openapi.description").getString()
        }
    }
}