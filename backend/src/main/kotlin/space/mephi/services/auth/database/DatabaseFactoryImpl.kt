package space.mephi.services.auth.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import space.mephi.services.auth.config.DatabaseConfig

class DatabaseFactoryImpl : DatabaseFactory {

    private val dbConfig = DatabaseConfig()

    override fun connect() {
        Database.connect(hikari())
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig().apply {
            driverClassName = dbConfig.driverClassName
            jdbcUrl = dbConfig.jdbcUrl
            username = dbConfig.username
            password = dbConfig.password
        }
        config.validate()
        return HikariDataSource(config)
    }
}