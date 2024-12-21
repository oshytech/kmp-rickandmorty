package oshy.tech.rickandmorty

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform