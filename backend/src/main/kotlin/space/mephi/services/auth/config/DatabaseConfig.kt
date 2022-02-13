package space.mephi.services.auth.config

data class DatabaseConfig(
    val driverClassName: String = "org.postgresql.Driver",
    val jdbcUrl: String = "jdbc:postgresql://localhost:54320/",
    val username: String = "postgres",
    val password: String = "postgres"
)