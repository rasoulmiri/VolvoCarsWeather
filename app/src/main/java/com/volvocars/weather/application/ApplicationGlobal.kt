package com.volvocars.weather.application

import androidx.multidex.MultiDexApplication
import com.volvocars.weather.main.di.MainPageInjector
import com.volvocars.weather.repository.di.RepositoryInjector
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApplicationGlobal : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        initialKoin()

    }

    private fun initialKoin() {
        startKoin {
            androidLogger(Level.ERROR).androidContext(this@ApplicationGlobal)
                .modules(RepositoryInjector.provideDependencies())
                .modules(MainPageInjector.provideDependencies())
        }
    }

}