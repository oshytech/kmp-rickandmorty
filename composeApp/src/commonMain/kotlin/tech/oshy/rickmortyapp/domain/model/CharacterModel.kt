package tech.oshy.rickmortyapp.domain.model

data class CharacterModel(
    val id:Int,
    val name:String,
    val isAlive:Boolean,
    val image:String
)
