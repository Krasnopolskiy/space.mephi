package space.mephi.services.auth.data.dao

import org.jetbrains.exposed.dao.id.UUIDTable

object CredentialsTable : UUIDTable() {
    val username = text("username").uniqueIndex()
    val hash = binary("hash")
}
