package com.volvocars.weather.main.data.datasource

import com.volvocars.weather.main.data.entity.CityWeatherResponseEntity
import com.volvocars.weather.repository.ResultModel


interface WeatherDataSource {
    suspend fun getWeatherCity(woeid: Long): ResultModel<CityWeatherResponseEntity>
}