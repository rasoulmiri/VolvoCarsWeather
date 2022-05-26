package com.volvocars.weather.main.data.datasource

import com.volvocars.weather.base.utils.DataProviderFromResourceFolderUtils
import com.volvocars.weather.main.data.entity.CityWeatherResponseEntity
import com.volvocars.weather.repository.ResultModel

class WeatherMockDataSourceImpl() : WeatherDataSource {

    override suspend fun getWeatherCity(woeid: Long): ResultModel<CityWeatherResponseEntity> {
        return ResultModel.Success(WeatherMock.provideSuccessfulResponse())
    }
    
}

object WeatherMock {
    
    const val weather_4118_success = "json/weather_4118_success.json"

    fun provideSuccessfulResponse(): CityWeatherResponseEntity {
        return DataProviderFromResourceFolderUtils.getModelFromFileResource(
            weather_4118_success,
            CityWeatherResponseEntity::class.java
        )
    }
}