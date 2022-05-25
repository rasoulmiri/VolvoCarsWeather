package com.volvocars.weather.main.data.datasource

import com.volvocars.weather.main.data.entity.CityWeatherResponse
import com.volvocars.weather.repository.ResultModel


interface WeatherDataSource {
    suspend fun getWeatherCity(woeid: Long): ResultModel<CityWeatherResponse>
}