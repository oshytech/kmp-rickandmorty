package tech.oshy.rickmortyapp.data

import tech.oshy.rickmortyapp.data.remote.ApiService
import tech.oshy.rickmortyapp.domain.Repository
import tech.oshy.rickmortyapp.domain.model.CharacterModel

class RepositoryImpl(
    private val apiService: ApiService
): Repository {
    override suspend fun getCharacter(id: Int): CharacterModel {
        return apiService.getSingleCharacter(id).toDomain()

    }
}