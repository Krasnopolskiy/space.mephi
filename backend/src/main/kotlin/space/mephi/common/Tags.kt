package space.mephi.common

import com.papsign.ktor.openapigen.APITag

enum class SpaceTag(override val description: String) : APITag {
    Auth("Авторизация")
}
