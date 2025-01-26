package tech.oshy.rickmortyapp.data.remote.response

import kotlinx.serialization.Serializable
import tech.oshy.rickmortyapp.domain.model.CharacterModel

@Serializable
data class CharacterResponse(
    val id: String,
    val status: String,
    val image: String
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id,
            isAlive = status.lowercase() == "alive",
            image = image
        )
    }
}
