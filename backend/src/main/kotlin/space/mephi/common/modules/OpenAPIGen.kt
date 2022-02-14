package space.mephi.common.modules

import com.papsign.ktor.openapigen.OpenAPIGen
import com.papsign.ktor.openapigen.openAPIGen
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

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

fun Application.openapiRouting() {
    routing {
        get("/openapi.json") {
            call.respond(application.openAPIGen.api.serialize())
        }
        get("/") {
            call.respondRedirect("/swagger-ui/index.html?url=/openapi.json", true)
        }
    }
}