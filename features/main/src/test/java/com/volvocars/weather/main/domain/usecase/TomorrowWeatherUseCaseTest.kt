package com.volvocars.weather.main.domain.usecase

import com.volvocars.weather.dataprovider.WeatherDataProviderFromJson
import com.volvocars.weather.main.domain.WeatherRepository
import com.volvocars.weather.repository.ResultModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class TomorrowWeatherUseCaseTest {

    // Mock
    private val weatherRepository: WeatherRepository = mockk()

    // Class for test
    private val tomorrowWeatherUseCase = TomorrowWeatherUseCase(weatherRepository)

    @Test
    fun `when use case execute and woeid is not null then weatherRepository called`() =
        runBlocking {

            // Given
            val woeid = 4118L
            coEvery {
                weatherRepository.getWeatherCity(woeid)
            } returns ResultModel.Success(WeatherDataProviderFromJson.provideSuccessfulResponse())

            // When
            tomorrowWeatherUseCase.executeAsync(woeid)

            // Then
            coVerify {
                weatherRepository.getWeatherCity(woeid)
            }

        }

    @Test
    fun `when use case execute and woeid is null then weatherRepository called`() = runBlocking {

        // Given
        val woeid = null
        coEvery {
            weatherRepository.getWeatherCity(woeid ?: 0)
        } returns ResultModel.Success(WeatherDataProviderFromJson.provideSuccessfulResponse())

        // When
        tomorrowWeatherUseCase.executeAsync(woeid)

        // Then
        coVerify(exactly = 0) {
            weatherRepository.getWeatherCity(woeid ?: 0)
        }

    }
}