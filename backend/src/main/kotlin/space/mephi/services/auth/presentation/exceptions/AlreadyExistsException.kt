package space.mephi.services.auth.presentation.exceptions

import space.mephi.common.exceptions.ForbiddenException

class AlreadyExistsException : ForbiddenException("A user with this email already exists")