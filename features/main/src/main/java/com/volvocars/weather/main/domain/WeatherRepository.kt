package com.volvocars.weather.main.domain

import com.volvocars.weather.main.data.entity.CityWeatherResponseEntity
import com.volvocars.weather.repository.ResultModel

interface WeatherRepository {
    suspend fun getWeatherCity(woeid: Long): ResultModel<CityWeatherResponseEntity>
}