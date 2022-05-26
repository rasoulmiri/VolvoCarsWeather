package com.volvocars.weather.main.data

import com.volvocars.weather.dataprovider.WeatherDataProviderFromJson
import com.volvocars.weather.main.data.datasource.WeatherDataSource
import com.volvocars.weather.repository.ResultModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class WeatherRepositoryImplTest {

    // Mock
    private val weatherDataSource: WeatherDataSource = mockk()

    // Class for test
    private val weatherRepositoryImpl = WeatherRepositoryImpl(weatherDataSource)

    @Test
    fun `get weather of the city by woeid in remote repository then call getWeatherCity in dataSource`() =
        runBlocking {

            // Given
            val woeid = 4118L
            coEvery {
                weatherDataSource.getWeatherCity(woeid)
            } returns ResultModel.Success(WeatherDataProviderFromJson.provideSuccessfulResponse())

            // When
            weatherRepositoryImpl.getWeatherCity(woeid)

            // Then
            coVerify {
                weatherDataSource.getWeatherCity(woeid)
            }

        }


}