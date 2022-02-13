package space.mephi.services.auth.domain.adapters

import space.mephi.services.auth.data.dao.CredentialsDAO
import space.mephi.services.auth.domain.dto.Credentials

fun CredentialsDAO.toDTO() = Credentials(username, hash)