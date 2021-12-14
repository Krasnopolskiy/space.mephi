package ru.mephi.space.routes.authenticate

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import ru.mephi.space.database.UserController
import ru.mephi.space.exceptions.BadRequestException
import ru.mephi.space.models.User

fun Route.signUp() {
    post("/signup") {
        val user = call.receiveOrNull<User>() ?: throw BadRequestException("Incorrect user data")
        UserController.signUpUser(user)
        call.respond(user)
    }
}