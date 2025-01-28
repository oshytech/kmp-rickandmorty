package tech.oshy.rickmortyapp.domain

import tech.oshy.rickmortyapp.domain.model.CharacterModel

class GetRandomCharacter(private val repository: Repository) {
    suspend operator fun invoke(): CharacterModel {
        return repository.getCharacter((1..826).random())
    }
}