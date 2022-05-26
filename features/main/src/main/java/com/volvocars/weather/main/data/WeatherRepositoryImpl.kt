package com.volvocars.weather.main.data

import com.volvocars.weather.main.data.datasource.WeatherDataSource
import com.volvocars.weather.main.data.entity.CityWeatherResponseEntity
import com.volvocars.weather.main.domain.WeatherRepository
import com.volvocars.weather.repository.ResultModel

class WeatherRepositoryImpl(private val weatherDataSource: WeatherDataSource) : WeatherRepository {
    override suspend fun getWeatherCity(woeid: Long): ResultModel<CityWeatherResponseEntity> {
        return weatherDataSource.getWeatherCity(woeid = woeid)
    }
}