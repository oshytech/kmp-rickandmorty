package tech.oshy.rickmortyapp.ui.core.navigation.botomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import tech.oshy.rickmortyapp.ui.core.navigation.Routes
import tech.oshy.rickmortyapp.ui.home.tabs.characters.CharactersScreen
import tech.oshy.rickmortyapp.ui.home.tabs.episodes.EpisodesScreen

@Composable
fun NavigationBottomWrapper(navController:NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Episodes.route) {
        composable(Routes.Episodes.route) {
            EpisodesScreen()
        }
        composable(Routes.Characters.route) {
            CharactersScreen()
        }
    }
}