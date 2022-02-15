package space.mephi.services.auth.bootstrap

import io.ktor.application.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import space.mephi.services.auth.data.dao.CredentialsTable
import space.mephi.services.auth.database.DatabaseFactoryImpl

fun Application.initDatabase() {
    val db = DatabaseFactoryImpl()
    db.connect()
    transaction { SchemaUtils.create(CredentialsTable) }
}