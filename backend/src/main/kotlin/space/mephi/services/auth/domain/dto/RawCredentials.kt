package space.mephi.services.auth.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class RawCredentials(
    val username: String,
    val password: String
)