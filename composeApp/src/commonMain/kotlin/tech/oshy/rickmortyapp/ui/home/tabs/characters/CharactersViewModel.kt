package tech.oshy.rickmortyapp.ui.home.tabs.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tech.oshy.rickmortyapp.domain.GetRandomCharacter

class CharactersViewModel(val getRandomCharacter: GetRandomCharacter): ViewModel() {
    private val _state = MutableStateFlow<CharactersState>(CharactersState())
    val state:StateFlow<CharactersState> = _state

    init {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                getRandomCharacter()
            }
            _state.update { it.copy(characterOfTheDay = result) }
        }
    }
}