package tech.oshy.rickmortyapp.domain

import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow
import tech.oshy.rickmortyapp.domain.model.CharacterModel

interface Repository {
    suspend fun getCharacter(id: Int): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
}