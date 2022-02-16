package space.mephi.services.auth.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class HashedCredentials(
    val email: String,
    val hash: ByteArray
)