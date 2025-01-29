package tech.oshy.rickmortyapp.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import tech.oshy.rickmortyapp.data.RepositoryImpl
import tech.oshy.rickmortyapp.data.remote.ApiService
import tech.oshy.rickmortyapp.domain.Repository

val dataModule = module {
    // Singleton
    single {
        HttpClient{
            install(ContentNegotiation){
                json(json = Json{ ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
            install(DefaultRequest){
                url{
                    protocol = URLProtocol.HTTPS
                    host = "rickandmortyapi.com"
                }
            }
        }
    }
    factoryOf(::ApiService)
    factory<Repository> {RepositoryImpl(get())  }
}