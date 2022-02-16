package space.mephi.services.user.domain.adapters

import space.mephi.services.user.data.dao.UserDAO
import space.mephi.services.user.domain.dto.User

fun UserDAO.toDTO() = User(email, firstName, secondName, thirdName, group, profilePicture)