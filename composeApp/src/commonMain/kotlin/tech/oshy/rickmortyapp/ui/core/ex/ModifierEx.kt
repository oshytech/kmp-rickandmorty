package tech.oshy.rickmortyapp.ui.core.ex

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

fun Modifier.vertical() = layout{ mesurable, constraint ->
    val placeable = mesurable.measure(constraint)
    layout(placeable.width, placeable.height){
        placeable.place(
            x = -((placeable.width/2) - (placeable.height/2)),
            y = ((placeable.height/2) - (placeable.width/2))
            )
    }

}