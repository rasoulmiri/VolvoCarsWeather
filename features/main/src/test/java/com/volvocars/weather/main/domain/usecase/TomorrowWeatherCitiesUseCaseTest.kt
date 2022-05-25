package com.volvocars.weather.main.domain.usecase

import com.volvocars.weather.dataprovider.WeatherDataProviderFromJson
import com.volvocars.weather.main.domain.mapper.mapToModel
import com.volvocars.weather.repository.ResultModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class TomorrowWeatherCitiesUseCaseTest {

    // Mock
    private val tomorrowWeatherUseCase: TomorrowWeatherUseCase = mockk()

    // Class for test
    private val tomorrowWeatherCitiesUseCase = TomorrowWeatherCitiesUseCase(tomorrowWeatherUseCase)

    @Test
    fun `when use case execute and cities is empty then result not emitted`() =
        runBlocking {

            // Given
            coEvery {
                tomorrowWeatherUseCase.executeAsync(any())
            } returns ResultModel.Success(WeatherDataProviderFromJson.provideSuccessfulResponse().consolidatedWeather?.map {
                it.mapToModel()
            }?.get(0))


            // When
            val request = TomorrowWeatherCitiesRequestModel(cities = arrayListOf())
            val flowResult = tomorrowWeatherCitiesUseCase.executeAsync(request)

            // Then
            // check size of emit
            assert(flowResult.count() == 0)

        }

    @Test
    fun `when use case execute and cities has 2 then result 2 times emitted`() =
        runBlocking {

            // Given
            coEvery {
                tomorrowWeatherUseCase.executeAsync(any())
            } returns ResultModel.Success(WeatherDataProviderFromJson.provideSuccessfulResponse().consolidatedWeather?.map {
                it.mapToModel()
            }?.get(0))


            // When
            val request = TomorrowWeatherCitiesRequestModel(cities = arrayListOf(
                CityModel(0,"Berlin",101),
                CityModel(1,"London",102)
            ))
            val flowResult = tomorrowWeatherCitiesUseCase.executeAsync(request)

            // Then
            // check size of emit
            assert(flowResult.count() == 2)

        }


}