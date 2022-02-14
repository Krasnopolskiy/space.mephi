package space.mephi.services.auth.domain.controllers

import space.mephi.services.auth.config.AlreadyExistsException
import space.mephi.services.auth.config.ForbiddenException
import space.mephi.services.auth.data.source.CredentialsDataSourceImpl
import space.mephi.services.auth.domain.adapters.hash
import space.mephi.services.auth.domain.dto.RawCredentials

object CredentialsControllerImpl : CredentialsController {
    override suspend fun signup(rawCredentials: RawCredentials) {
        val credentials = rawCredentials.hash()
        if (CredentialsDataSourceImpl.retrieveCredentials(credentials) != null)
            throw AlreadyExistsException("Username is already taken")
        CredentialsDataSourceImpl.addCredentials(rawCredentials.hash())
    }

    override suspend fun signin(rawCredentials: RawCredentials) {
        val credentials = rawCredentials.hash()
        CredentialsDataSourceImpl.retrieveCredentials(credentials).also {
            if (it == null || !it.hash.contentEquals(credentials.hash))
                throw ForbiddenException("Invalid credentials")
        }
    }
}