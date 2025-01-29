package tech.oshy.rickmortyapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level
import tech.oshy.rickmortyapp.di.initKoin

class RickMortyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin{
            androidLogger()
            androidContext(this@RickMortyApp)
        }
    }
}