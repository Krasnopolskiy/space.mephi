package space.mephi.services.auth.domain.adapters

import io.ktor.util.*
import space.mephi.services.auth.domain.dto.HashedCredentials
import space.mephi.services.auth.domain.dto.Credentials

private val digestFunction = getDigestFunction("SHA-256") { System.getenv("SALT") ?: "salt" }

fun Credentials.hash(): HashedCredentials {
    return HashedCredentials(email, digestFunction(password))
}