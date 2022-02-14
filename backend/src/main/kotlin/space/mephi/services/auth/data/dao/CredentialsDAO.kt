package space.mephi.services.auth.data.dao

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class CredentialsDAO(id: EntityID<UUID>) : Entity<UUID>(id) {
    companion object : EntityClass<UUID, CredentialsDAO>(CredentialsTable)

    var username by CredentialsTable.username
    var hash by CredentialsTable.hash
}