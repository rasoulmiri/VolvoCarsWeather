package com.volvocars.weather.main.di

import com.volvocars.weather.main.di.modules.weatherDataModule
import com.volvocars.weather.main.di.modules.weatherDomainModule
import com.volvocars.weather.main.di.modules.weatherPresentationModule


object MainPageInjector {
    fun provideDependencies() = listOf(
        weatherDataModule,
        weatherDomainModule,
        weatherPresentationModule
    )
}