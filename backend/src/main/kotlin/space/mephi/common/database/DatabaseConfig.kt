package space.mephi.common.database

import io.ktor.application.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import space.mephi.common.database.controllers.DatabaseFactoryImpl
import space.mephi.services.auth.data.dao.CredentialsTable
import space.mephi.services.user.data.dao.UserTable

data class DatabaseConfig(
    var driverClassName: String = "org.postgresql.Driver",
    var jdbcUrl: String = "jdbc:postgresql://localhost:54320/",
    var username: String = "postgres",
    var password: String = "postgres"
)

fun Application.configureDatabase() {
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
    transaction { SchemaUtils.create(UserTable) }
}