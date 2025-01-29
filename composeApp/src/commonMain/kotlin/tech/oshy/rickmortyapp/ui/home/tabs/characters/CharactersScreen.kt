package tech.oshy.rickmortyapp.ui.home.tabs.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import tech.oshy.rickmortyapp.domain.model.CharacterModel
import tech.oshy.rickmortyapp.ui.core.ex.vertical

@OptIn(KoinExperimentalAPI::class)
@Composable
fun CharactersScreen() {
    val charactersViewModel = koinViewModel<CharactersViewModel>()
    val state by charactersViewModel.state.collectAsState()

    Column(Modifier.fillMaxSize()) {
        CharacterOfTheDay(state.characterOfTheDay)
    }
}

@Composable
fun CharacterOfTheDay(characterModel: CharacterModel? = null) {
    Column {
        Card(modifier = Modifier.fillMaxWidth().height(400.dp), shape = RoundedCornerShape(12)){
            if(characterModel != null){
                Box(contentAlignment = Alignment.BottomStart){
                    Box(modifier = Modifier.fillMaxSize().background(Color.Green.copy(alpha = 0.5f)))
                    AsyncImage(
                        model = characterModel.image,
                        contentDescription = "Character of de day name: ${characterModel.name}",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Box(modifier = Modifier.fillMaxSize().background(
                      Brush.horizontalGradient(
                          0f to Color.Black.copy(alpha = 0.9f),
                          0.4f to Color.White.copy(alpha = 0.0f),
                      )
                    ))
                    Text(
                        characterModel.name,
                        fontSize = 40.sp,
                        maxLines = 1,
                        minLines = 1,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(horizontal = 24.dp, vertical = 16.dp)
                            .fillMaxWidth()
                            .vertical()
                            .rotate(-90f)
                    )
                }
            }else{
                Box(contentAlignment = Alignment.Center){
                    CircularProgressIndicator()
                }
            }
        }
    }
}