package space.mephi.services.auth.domain.adapters

import io.ktor.util.*
import space.mephi.services.auth.domain.dto.HashedCredentials
import space.mephi.services.auth.domain.dto.Credentials

//    TODO replace hardcoded salt with normal
private val digestFunction = getDigestFunction("SHA-256") { "salt" }

fun Credentials.hash(): HashedCredentials {
    return HashedCredentials(username, digestFunction(password))
}