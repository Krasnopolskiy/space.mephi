package space.mephi.services.auth.domain.controllers

import space.mephi.services.auth.data.source.CredentialsDataSourceImpl
import space.mephi.services.auth.domain.adapters.hash
import space.mephi.services.auth.domain.dto.Credentials
import space.mephi.services.auth.presentation.exceptions.AlreadyExistsException
import space.mephi.services.auth.presentation.exceptions.InvalidCredentialsException

object CredentialsControllerImpl : CredentialsController {
    override suspend fun signup(credentials: Credentials) {
        val hashedCredentials = credentials.hash()
        if (CredentialsDataSourceImpl.retrieveCredentials(hashedCredentials) != null)
            throw AlreadyExistsException()
        CredentialsDataSourceImpl.addCredentials(credentials.hash())
    }

    override suspend fun signin(credentials: Credentials) {
        val hashedCredentials = credentials.hash()
        CredentialsDataSourceImpl.retrieveCredentials(hashedCredentials).also {
            if (it == null || !it.hash.contentEquals(hashedCredentials.hash))
                throw InvalidCredentialsException()
        }
    }
}