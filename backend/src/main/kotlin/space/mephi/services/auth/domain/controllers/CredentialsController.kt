package space.mephi.services.auth.domain.controllers

import space.mephi.services.auth.domain.dto.RawCredentials

interface CredentialsController {
    suspend fun signup(rawCredentials: RawCredentials)
    suspend fun signin(rawCredentials: RawCredentials)
}