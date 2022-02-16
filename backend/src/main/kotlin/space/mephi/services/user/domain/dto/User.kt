package space.mephi.services.user.domain.dto

data class User(
    var email: String,
    var firstName: String,
    var secondName: String,
    var thirdName: String,
    var group: String,
    var profilePicture: String
)