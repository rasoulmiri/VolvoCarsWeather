package com.volvocars.weather.main.data.api

import com.volvocars.weather.main.data.entity.CityWeatherResponseEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApiService {

    @GET("api/location/{woeid}")
    fun getWeatherCity(@Path("woeid") woeid: Long): Call<CityWeatherResponseEntity>

}