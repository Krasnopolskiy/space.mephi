package space.mephi.services.auth.domain.controllers

import space.mephi.services.auth.data.source.CredentialsDataSourceImpl
import space.mephi.services.auth.domain.adapters.hash
import space.mephi.services.auth.domain.dto.RawCredentials
import space.mephi.services.auth.presentation.exceptions.AlreadyExistsException
import space.mephi.services.auth.presentation.exceptions.InvalidCredentialsException

object CredentialsControllerImpl : CredentialsController {
    override suspend fun signup(rawCredentials: RawCredentials) {
        val credentials = rawCredentials.hash()
        if (CredentialsDataSourceImpl.retrieveCredentials(credentials) != null)
            throw AlreadyExistsException()
        CredentialsDataSourceImpl.addCredentials(rawCredentials.hash())
    }

    override suspend fun signin(rawCredentials: RawCredentials) {
        val credentials = rawCredentials.hash()
        CredentialsDataSourceImpl.retrieveCredentials(credentials).also {
            if (it == null || !it.hash.contentEquals(credentials.hash))
                throw InvalidCredentialsException()
        }
    }
}