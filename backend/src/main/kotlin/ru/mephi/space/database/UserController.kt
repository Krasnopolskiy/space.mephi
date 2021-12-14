package ru.mephi.space.database
import ru.mephi.space.models.User

object UserController : Controller() {
    private val users = db.getCollection<User>()

    suspend fun signUpUser(user: User) {
        users.insertOne(user)
    }
}