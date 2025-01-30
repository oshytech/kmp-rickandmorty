package tech.oshy.rickmortyapp.data.remote.response

data class CharactersWrapperResponse(
    val info: InfoResponse,
    val results: List<CharacterResponse>
)
