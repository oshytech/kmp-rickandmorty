package tech.oshy.rickmortyapp.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

expect fun platformModule(): org.koin.core.module.Module

fun initKoin(config:KoinAppDeclaration? = null) {
    startKoin{
        config?.invoke(this)
        modules(dataModule, domainModule, uiModule, platformModule())
    }
}