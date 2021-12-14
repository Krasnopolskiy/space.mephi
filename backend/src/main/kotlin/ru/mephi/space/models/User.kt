package ru.mephi.space.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val email: String,
    val name: String,
    val surname: String,
    val patronymic: String,
    val birthday: Int,

    @Contextual
    val studyGroup: String
) : Model()
