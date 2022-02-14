package space.mephi.openapi

import com.papsign.ktor.openapigen.OpenAPIGen
import io.ktor.application.*

fun Application.installOpenAPIGen() {
    install(OpenAPIGen) {
        info {
            version = "0.0.1"
            title = "Space.MEPhI API"
            description = "Space.MEPhI description API" // todo add description
        }

        server("http://" +
                "${environment.config.property("ktor.deployment.host").getString()}:" +
                "${environment.config.property("ktor.deployment.port").getString()}/") {
            description = "Localhost server" //todo rename
        }
    }
}