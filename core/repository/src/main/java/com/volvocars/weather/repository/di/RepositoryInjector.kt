package com.volvocars.weather.repository.di


import com.volvocars.weather.repository.network.NetworkManager
import org.koin.dsl.module

object RepositoryInjector {

    fun provideDependencies() = module {
        single { NetworkManager(get()) }
    }
}