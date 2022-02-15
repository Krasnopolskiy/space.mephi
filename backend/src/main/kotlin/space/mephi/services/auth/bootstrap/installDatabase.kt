package space.mephi.services.auth.bootstrap

import io.ktor.application.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import space.mephi.services.auth.data.dao.CredentialsTable
import space.mephi.services.auth.database.DatabaseFactoryImpl

fun Application.installDatabase() {
    val deployment = false
    DatabaseFactoryImpl {
        driverClassName = environment.config.property("database.driver").getString()
        if (deployment) {
            jdbcUrl = environment.config.property("database.deployment.url").getString()
            username = environment.config.property("database.deployment.username").getString()
            password = environment.config.property("database.deployment.password").getString()
        }
    }.connect()
    transaction { SchemaUtils.create(CredentialsTable) }
}