package space.mephi.services.auth.config

data class DatabaseConfig(
    var driverClassName: String = "org.postgresql.Driver",
    var jdbcUrl: String = "jdbc:postgresql://localhost:54320/",
    var username: String = "postgres",
    var password: String = "postgres"
)