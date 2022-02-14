package space.mephi.openapi

import com.papsign.ktor.openapigen.openAPIGen
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.openApiRouting() {
    routing {
        openAPIRoot()
        openAPISchema()
    }
}

fun Route.openAPIRoot() {
    get("/") {
        call.respondRedirect("/swagger-ui/index.html", true)
    }
}

fun Route.openAPISchema() {
    get("/openapi.json") {
        call.respond(application.openAPIGen.api.serialize())
    }
}
