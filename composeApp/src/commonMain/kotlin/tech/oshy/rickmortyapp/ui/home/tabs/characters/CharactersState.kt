package tech.oshy.rickmortyapp.ui.home.tabs.characters

import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import tech.oshy.rickmortyapp.domain.model.CharacterModel

data class CharactersState(
    val characterOfTheDay:CharacterModel? = null,
    val characters: Flow<PagingData<CharacterModel>> = emptyFlow()
)