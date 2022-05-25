package com.volvocars.weather.main.di.modules


import com.volvocars.weather.main.data.WeatherRepositoryImpl
import com.volvocars.weather.main.data.api.WeatherApiService
import com.volvocars.weather.main.data.datasource.WeatherDataSource
import com.volvocars.weather.main.data.datasource.WeatherMockDataSourceImpl
import com.volvocars.weather.main.domain.WeatherRepository
import com.volvocars.weather.repository.network.NetworkManager
import org.koin.dsl.module

val weatherDataModule = module {

    factory<WeatherDataSource> { WeatherMockDataSourceImpl() }
    factory<WeatherRepository> { WeatherRepositoryImpl(get()) }
    // TODO change this to remote source if the website was ready
//    factory<WeatherDataSource> { WeatherRemoteDataSourceImpl(get()) }

    factory { provideApiService(get()) }
}

private fun provideApiService(networkManager: NetworkManager): WeatherApiService {
    return networkManager.create(WeatherApiService::class.java)
}