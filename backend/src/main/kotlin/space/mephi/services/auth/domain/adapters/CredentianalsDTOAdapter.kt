package space.mephi.services.auth.domain.adapters

import space.mephi.services.auth.data.dao.CredentialsDAO
import space.mephi.services.auth.domain.dto.HashedCredentials

fun CredentialsDAO.toDTO() = HashedCredentials(email, hash)