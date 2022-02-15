package space.mephi.services.auth.domain.controllers

import space.mephi.services.auth.domain.dto.Credentials

interface CredentialsController {
    suspend fun signup(credentials: Credentials)
    suspend fun signin(credentials: Credentials)
}