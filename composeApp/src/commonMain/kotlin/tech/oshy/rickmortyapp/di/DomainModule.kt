package tech.oshy.rickmortyapp.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import tech.oshy.rickmortyapp.domain.GetRandomCharacter


val domainModule = module {
    factoryOf(::GetRandomCharacter)
}