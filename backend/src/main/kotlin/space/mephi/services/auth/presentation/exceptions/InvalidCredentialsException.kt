package space.mephi.services.auth.presentation.exceptions

import space.mephi.common.exceptions.ForbiddenException

class InvalidCredentialsException : ForbiddenException("Invalid credentials")