package space.mephi.services.user.data.source

import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import space.mephi.services.user.data.dao.UserDAO
import space.mephi.services.user.data.dao.UserTable
import space.mephi.services.user.domain.adapters.toDTO
import space.mephi.services.user.domain.dto.User

object UserDataSourceImpl : UserDataSource {
    override suspend fun addUser(user: User) {
        transaction {
            UserDAO.new {
                email = user.email
                firstName = user.firstName
                secondName = user.secondName
                thirdName = user.thirdName
                group = user.group
                profilePicture = user.profilePicture
            }
        }
    }

    override suspend fun retrieveUser(email: String): User? {
        return transaction {
            val query = UserTable.select { UserTable.email eq email }
            UserDAO.wrapRows(query).toList().firstOrNull()
        }?.toDTO()
    }
}