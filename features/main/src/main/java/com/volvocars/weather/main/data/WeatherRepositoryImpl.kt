package com.volvocars.weather.main.data

import com.volvocars.weather.main.data.entity.CityWeatherResponse
import com.volvocars.weather.main.data.datasource.WeatherDataSource
import com.volvocars.weather.main.domain.WeatherRepository
import com.volvocars.weather.repository.ResultModel

class WeatherRepositoryImpl(private val weatherRemoteDataSource: WeatherDataSource) : WeatherRepository {
    override suspend fun getWeatherCity(woeid: Long): ResultModel<CityWeatherResponse> {
        return weatherRemoteDataSource.getWeatherCity(woeid = woeid)
    }
}