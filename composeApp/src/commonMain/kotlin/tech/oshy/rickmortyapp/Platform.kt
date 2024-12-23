package tech.oshy.rickmortyapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform