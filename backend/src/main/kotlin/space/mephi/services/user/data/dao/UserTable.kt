package space.mephi.services.user.data.dao

import org.jetbrains.exposed.dao.id.UUIDTable


object UserTable : UUIDTable() {
    val email = text("email").uniqueIndex()
    val firstName = text("firstName")
    val secondName = text("secondName")
    val thirdName = text("thirdName")
    val group = text("group")
    val profilePicture = text("profilePicture") // todo придумать, как это реализовать
}