package space.mephi.services.auth.data.dao

import org.jetbrains.exposed.dao.id.UUIDTable

object CredentialsTable : UUIDTable() {
    val email = text("email").uniqueIndex()
    val hash = binary("hash")
}