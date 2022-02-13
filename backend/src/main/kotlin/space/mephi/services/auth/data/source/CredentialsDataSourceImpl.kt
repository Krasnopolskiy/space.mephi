package space.mephi.services.auth.data.source

import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import space.mephi.services.auth.data.dao.CredentialsDAO
import space.mephi.services.auth.data.dao.CredentialsTable
import space.mephi.services.auth.domain.adapters.toDTO
import space.mephi.services.auth.domain.dto.Credentials

object CredentialsDataSourceImpl : CredentialsDataSource {
    override suspend fun addCredentials(credentials: Credentials) {
        transaction {
            CredentialsDAO.new {
                username = credentials.username
                hash = credentials.hash
            }
        }
    }

    override suspend fun retrieveCredentials(credentials: Credentials): Credentials? {
        return transaction {
            val query = CredentialsTable.select { CredentialsTable.username eq credentials.username }
            CredentialsDAO.wrapRows(query).toList().firstOrNull()
        }?.toDTO()
    }
}