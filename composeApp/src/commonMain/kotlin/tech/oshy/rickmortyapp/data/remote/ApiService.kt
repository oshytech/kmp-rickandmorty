package tech.oshy.rickmortyapp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import tech.oshy.rickmortyapp.data.remote.response.CharacterResponse
import tech.oshy.rickmortyapp.data.remote.response.CharactersWrapperResponse

class ApiService(private val client:HttpClient) {
    suspend fun getSingleCharacter(id:Int): CharacterResponse {
        return client.get("api/character/$id").body<CharacterResponse>()
    }
    suspend fun getAllCharacters(page:Int): CharactersWrapperResponse {
        return client.get("/api/character"){
            parameter("page", page)
        }.body()
    }
}