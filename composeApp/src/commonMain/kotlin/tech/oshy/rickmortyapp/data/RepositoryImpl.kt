package tech.oshy.rickmortyapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow
import tech.oshy.rickmortyapp.data.remote.ApiService
import tech.oshy.rickmortyapp.data.remote.paging.CharactersPagingSource
import tech.oshy.rickmortyapp.domain.Repository
import tech.oshy.rickmortyapp.domain.model.CharacterModel

class RepositoryImpl(
    private val apiService: ApiService,
    private val charactersPagingSource: CharactersPagingSource
) : Repository {

    companion object {
        private const val PAGE_SIZE = 20
        private const val PREFETCH_DISTANCE = 5
    }

    override suspend fun getCharacter(id: Int): CharacterModel {
        return apiService.getSingleCharacter(id).toDomain()

    }

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(config = PagingConfig(pageSize = PAGE_SIZE, prefetchDistance = 5),
            pagingSourceFactory = { charactersPagingSource }).flow
    }
}