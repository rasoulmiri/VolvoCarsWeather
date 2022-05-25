package com.volvocars.weather.dataprovider

import com.volvocars.weather.main.data.entity.CityWeatherResponse
import com.volvocars.weather.base.utils.DataProviderFromResourceFolderUtils


class WeatherDataProviderFromJson {

    companion object {

        private const val weather_4118_success = "json/weather_4118_success.json"

        fun provideSuccessfulResponse(): CityWeatherResponse {
            return DataProviderFromResourceFolderUtils.getModelFromFileResource(
                weather_4118_success,
                CityWeatherResponse::class.java
            )
        }


    }
}