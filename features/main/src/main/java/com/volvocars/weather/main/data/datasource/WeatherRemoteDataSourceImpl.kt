package com.volvocars.weather.main.data.datasource

import com.volvocars.weather.main.data.api.WeatherApiService
import com.volvocars.weather.main.data.entity.CityWeatherResponse
import com.volvocars.weather.repository.ResultModel
import com.volvocars.weather.repository.awaitResult

class WeatherRemoteDataSourceImpl(
    private val apiService: WeatherApiService,
) : WeatherDataSource {

    override suspend fun getWeatherCity(woeid:Long): ResultModel<CityWeatherResponse> {
        return apiService.getWeatherCity(woeid = woeid).awaitResult { it }
    }

}