package space.mephi.services.auth.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import space.mephi.services.auth.config.DatabaseConfig

class DatabaseFactoryImpl(dbConfig: DatabaseConfig.() -> Unit) : DatabaseFactory {
    private val dbConfig: DatabaseConfig

    init {
        this.dbConfig = DatabaseConfig().apply(dbConfig)
    }

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