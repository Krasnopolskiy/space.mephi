package space.mephi.services.user.data.dao

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class UserDAO(id: EntityID<UUID>) : Entity<UUID>(id) {
    companion object : EntityClass<UUID, UserDAO>(UserTable)

    var email by UserTable.email
    var firstName by UserTable.firstName
    var secondName by UserTable.secondName
    var thirdName by UserTable.thirdName
    var group by UserTable.group
    var profilePicture by UserTable.profilePicture

}