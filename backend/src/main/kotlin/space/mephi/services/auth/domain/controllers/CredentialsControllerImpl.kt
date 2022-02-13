package space.mephi.services.auth.domain.controllers

import space.mephi.services.auth.data.source.CredentialsDataSourceImpl
import space.mephi.services.auth.domain.adapters.hash
import space.mephi.services.auth.domain.dto.*

object CredentialsControllerImpl : CredentialsController {
    override suspend fun signup(rawCredentials: RawCredentials) {
        val credentials = rawCredentials.hash()
        if (CredentialsDataSourceImpl.retrieveCredentials(credentials) != null)
            throw Exception("Username is already taken")
        CredentialsDataSourceImpl.addCredentials(rawCredentials.hash())
    }

    override suspend fun signin(rawCredentials: RawCredentials) {
        val credentials = rawCredentials.hash()
        CredentialsDataSourceImpl.retrieveCredentials(credentials).also {
            if (it == null || !it.hash.contentEquals(credentials.hash)) throw Exception("Invalid credentials")
        }
    }
}