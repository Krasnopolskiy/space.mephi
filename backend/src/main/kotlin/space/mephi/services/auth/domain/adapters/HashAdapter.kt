package space.mephi.services.auth.domain.adapters

import io.ktor.util.*
import space.mephi.services.auth.domain.dto.Credentials
import space.mephi.services.auth.domain.dto.RawCredentials

//    TODO replace hardcoded salt with normal
private val digestFunction = getDigestFunction("SHA-256") { "salt" }

fun RawCredentials.hash(): Credentials {
    return Credentials(username, digestFunction(password))
}