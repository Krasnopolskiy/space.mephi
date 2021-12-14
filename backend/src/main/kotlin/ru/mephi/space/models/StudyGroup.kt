package ru.mephi.space.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class StudyGroup(
    val code: String,
    val enterYear: Int,
    val institute: String,
    val users: List<@Contextual String>
) : Model()
