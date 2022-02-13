package space.mephi.services.auth.data.source

import space.mephi.services.auth.domain.dto.Credentials

interface CredentialsDataSource {
    suspend fun addCredentials(credentials: Credentials)
    suspend fun retrieveCredentials(credentials: Credentials): Credentials?
}