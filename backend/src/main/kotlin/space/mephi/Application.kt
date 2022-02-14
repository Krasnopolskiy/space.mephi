package space.mephi

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import space.mephi.services.auth.data.dao.CredentialsTable
import space.mephi.services.auth.database.DatabaseFactoryImpl
import space.mephi.services.auth.presentation.authRouting

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    install(ContentNegotiation) {
        jackson()
    }
    val db = DatabaseFactoryImpl()
    db.connect()
    transaction { SchemaUtils.create(CredentialsTable) }
    authRouting()
}
