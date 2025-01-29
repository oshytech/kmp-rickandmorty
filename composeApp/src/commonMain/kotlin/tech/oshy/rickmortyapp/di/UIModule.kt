package tech.oshy.rickmortyapp.di

import org.koin.compose.viewmodel.dsl.viewModelOf
import tech.oshy.rickmortyapp.ui.home.tabs.characters.CharactersViewModel
import tech.oshy.rickmortyapp.ui.home.tabs.episodes.EpisodesViewModel

val uiModule = org.koin.dsl.module {
    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharactersViewModel)
}