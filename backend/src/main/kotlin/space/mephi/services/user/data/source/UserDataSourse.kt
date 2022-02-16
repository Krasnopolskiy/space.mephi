package space.mephi.services.user.data.source

import space.mephi.services.user.domain.dto.User

interface UserDataSource {
    suspend fun addUser(user: User)
    suspend fun retrieveUser(email: String): User?
}