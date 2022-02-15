package space.mephi.services.auth.data.source

import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import space.mephi.services.auth.data.dao.CredentialsDAO
import space.mephi.services.auth.data.dao.CredentialsTable
import space.mephi.services.auth.domain.adapters.toDTO
import space.mephi.services.auth.domain.dto.HashedCredentials

object CredentialsDataSourceImpl : CredentialsDataSource {
    override suspend fun addCredentials(hashedCredentials: HashedCredentials) {
        transaction {
            CredentialsDAO.new {
                username = hashedCredentials.username
                hash = hashedCredentials.hash
            }
        }
    }

    override suspend fun retrieveCredentials(hashedCredentials: HashedCredentials): HashedCredentials? {
        return transaction {
            val query = CredentialsTable.select { CredentialsTable.username eq hashedCredentials.username }
            CredentialsDAO.wrapRows(query).toList().firstOrNull()
        }?.toDTO()
    }
}