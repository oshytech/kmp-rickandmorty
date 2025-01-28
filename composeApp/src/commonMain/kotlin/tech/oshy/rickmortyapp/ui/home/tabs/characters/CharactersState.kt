package tech.oshy.rickmortyapp.ui.home.tabs.characters

import tech.oshy.rickmortyapp.domain.model.CharacterModel

data class CharactersState(
    val characterOfTheDay:CharacterModel? = null
)