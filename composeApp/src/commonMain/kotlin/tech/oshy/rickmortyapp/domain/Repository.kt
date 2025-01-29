package tech.oshy.rickmortyapp.domain

import tech.oshy.rickmortyapp.domain.model.CharacterModel

interface Repository {
    suspend fun getCharacter(id: Int): CharacterModel
}