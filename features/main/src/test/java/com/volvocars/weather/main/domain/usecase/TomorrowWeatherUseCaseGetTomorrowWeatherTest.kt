package com.volvocars.weather.main.domain.usecase

import com.volvocars.weather.main.data.entity.ConsolidatedWeatherEntity
import com.volvocars.weather.main.domain.WeatherRepository
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.*

@ExperimentalCoroutinesApi
@RunWith(Parameterized::class)
class TomorrowWeatherUseCaseGetTomorrowWeatherTest(
    private val today: Calendar,
    private val daysWeather: ArrayList<ConsolidatedWeatherEntity>?,
    private val tomorrowExpected: ConsolidatedWeatherEntity?,
) {

    // <editor-fold defaultState="collapsed" desc="Input Data Parameterized">
    class InputData(
        private val today: Calendar,
        private val daysWeather: ArrayList<ConsolidatedWeatherEntity>?,
        private val tomorrow: ConsolidatedWeatherEntity?,
    ) {
        fun toArray(): Array<Any?> {
            return arrayOf(today, daysWeather, tomorrow)
        }
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters(name = "today:{0}, daysWeather:{1}, tomorrow:{2}")
        fun data() = listOf(

            InputData(
                today = Calendar.getInstance().apply {
                    this.set(Calendar.YEAR, 2021)
                    this.set(Calendar.MONTH, 11)
                    this.set(Calendar.DATE, 30)
                },
                daysWeather = null,
                tomorrow = null
            ).toArray(),

            InputData(
                today = Calendar.getInstance().apply {
                    this.set(Calendar.YEAR, 2021)
                    this.set(Calendar.MONTH, 0)
                    this.set(Calendar.DATE, 1)
                },
                daysWeather = arrayListOf(
                    ConsolidatedWeatherEntity(applicableDate = "2021-01-02")
                ),
                tomorrow = ConsolidatedWeatherEntity(applicableDate = "2021-01-02")
            ).toArray(),

            InputData(
                today = Calendar.getInstance().apply {
                    this.set(Calendar.YEAR, 2021)
                    this.set(Calendar.MONTH, 0)
                    this.set(Calendar.DATE, 1)
                },
                daysWeather = arrayListOf(
                    ConsolidatedWeatherEntity(applicableDate = "2021-01-02"),
                    ConsolidatedWeatherEntity(applicableDate = "2021-01-03"),
                    ConsolidatedWeatherEntity(applicableDate = "2021-01-04")
                ),
                tomorrow = ConsolidatedWeatherEntity(applicableDate = "2021-01-02")
            ).toArray(),


            InputData(
                today = Calendar.getInstance().apply {
                    this.set(Calendar.YEAR, 2021)
                    this.set(Calendar.MONTH, 0)
                    this.set(Calendar.DATE, 1)
                },
                daysWeather = arrayListOf(
                    ConsolidatedWeatherEntity(applicableDate = "2021-01-03"),
                    ConsolidatedWeatherEntity(applicableDate = "2021-01-04"),
                    ConsolidatedWeatherEntity(applicableDate = "2021-01-05")
                ),
                tomorrow = null
            ).toArray(),

            InputData(
                today = Calendar.getInstance().apply {
                    this.set(Calendar.YEAR, 2021)
                    this.set(Calendar.MONTH, 0)
                    this.set(Calendar.DATE, 1)
                },
                daysWeather = arrayListOf(
                    ConsolidatedWeatherEntity(applicableDate = "2021-02-02"),
                    ConsolidatedWeatherEntity(applicableDate = "2021-02-03"),
                    ConsolidatedWeatherEntity(applicableDate = "2021-02-04")
                ),
                tomorrow = null
            ).toArray(),


            InputData(
                today = Calendar.getInstance().apply {
                    this.set(Calendar.YEAR, 2021)
                    this.set(Calendar.MONTH, 0)
                    this.set(Calendar.DATE, 1)
                },
                daysWeather = arrayListOf(
                    ConsolidatedWeatherEntity(applicableDate = "2022-02-02"),
                    ConsolidatedWeatherEntity(applicableDate = "2022-02-03"),
                    ConsolidatedWeatherEntity(applicableDate = "2022-02-04")
                ),
                tomorrow = null
            ).toArray(),


            InputData(
                today = Calendar.getInstance().apply {
                    this.set(Calendar.YEAR, 2021)
                    this.set(Calendar.MONTH, 0)
                    this.set(Calendar.DATE, 1)
                },
                daysWeather = arrayListOf(
                    ConsolidatedWeatherEntity(applicableDate = "2020-02-02"),
                    ConsolidatedWeatherEntity(applicableDate = "2020-02-03"),
                    ConsolidatedWeatherEntity(applicableDate = "2020-02-04")
                ),
                tomorrow = null
            ).toArray(),

            InputData(
                today = Calendar.getInstance().apply {
                    this.set(Calendar.YEAR, 2021)
                    this.set(Calendar.MONTH, 11)
                    this.set(Calendar.DATE, 31)
                },
                daysWeather = arrayListOf(
                    ConsolidatedWeatherEntity(applicableDate = "2022-01-01"),
                    ConsolidatedWeatherEntity(applicableDate = "2022-02-02"),
                    ConsolidatedWeatherEntity(applicableDate = "2022-02-03")
                ),
                tomorrow = ConsolidatedWeatherEntity(applicableDate = "2022-01-01")
            ).toArray(),

            InputData(
                today = Calendar.getInstance().apply {
                    this.set(Calendar.YEAR, 2021)
                    this.set(Calendar.MONTH, 11)
                    this.set(Calendar.DATE, 30)
                },
                daysWeather = arrayListOf(
                    ConsolidatedWeatherEntity(applicableDate = "2022-01-01"),
                    ConsolidatedWeatherEntity(applicableDate = "2022-02-02"),
                    ConsolidatedWeatherEntity(applicableDate = "2022-02-03")
                ),
                tomorrow = null
            ).toArray(),


            )
    }
    // </editor-fold>

    // Mock
    private val weatherRepository: WeatherRepository = mockk()

    // Class for test
    private val tomorrowWeatherUseCase = TomorrowWeatherUseCase(this.weatherRepository)

    @Test
    fun `check getTomorrowWeather`() {

        // When
        val tomorrowWeather = tomorrowWeatherUseCase.getTomorrowWeather(today, daysWeather)

        // Then
        assertEquals(tomorrowExpected, tomorrowWeather)
    }

}