package com.volvocars.weather.main.di.modules

import com.volvocars.weather.main.domain.usecase.TomorrowWeatherCitiesUseCase
import com.volvocars.weather.main.domain.usecase.TomorrowWeatherUseCase
import org.koin.dsl.module

val weatherDomainModule = module {
    factory { TomorrowWeatherUseCase(get()) }
    factory { TomorrowWeatherCitiesUseCase(get()) }
}