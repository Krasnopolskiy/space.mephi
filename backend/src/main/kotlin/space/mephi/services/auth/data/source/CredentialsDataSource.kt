package space.mephi.services.auth.data.source

import space.mephi.services.auth.domain.dto.HashedCredentials

interface CredentialsDataSource {
    suspend fun addCredentials(hashedCredentials: HashedCredentials)
    suspend fun retrieveCredentials(hashedCredentials: HashedCredentials): HashedCredentials?
}