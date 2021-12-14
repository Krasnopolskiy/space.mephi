package ru.mephi.space.views

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.util.pipeline.*
import ru.mephi.space.database.UserController
import ru.mephi.space.exceptions.BadRequestException
import ru.mephi.space.models.User

suspend fun PipelineContext<Unit, ApplicationCall>.signUpUser() {
    val user = call.receiveOrNull<User>() ?: throw BadRequestException("Incorrect user data")
    UserController.signUpUser(user)
    call.respond(user)
}