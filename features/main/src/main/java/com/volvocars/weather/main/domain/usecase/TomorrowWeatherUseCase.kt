package com.volvocars.weather.main.domain.usecase

import com.volvocars.weather.base.usecase.AsyncSuspendUseCase
import com.volvocars.weather.base.utils.date.DateConvertorUtils
import com.volvocars.weather.base.utils.date.DateFormat.Companion.formatJustDate
import com.volvocars.weather.base.utils.date.DateFormat.Companion.formatZIndex
import com.volvocars.weather.main.domain.WeatherRepository
import com.volvocars.weather.main.domain.model.ConsolidatedWeatherModel
import com.volvocars.weather.repository.ResultModel
import com.volvocars.weather.repository.map

class TomorrowWeatherUseCase(
    private val repository: WeatherRepository,
) : AsyncSuspendUseCase<Long, ResultModel<ConsolidatedWeatherModel?>> {

    override suspend fun executeAsync(rq: Long): ResultModel<ConsolidatedWeatherModel?> {
        return repository.getWeatherCity(rq).map {

            val tomorrowWeather = it.consolidatedWeather?.getOrNull(0)

            tomorrowWeather?.let {
                ConsolidatedWeatherModel(
                    id = tomorrowWeather.id ?: 0L,
                    weatherStateName = tomorrowWeather.weatherStateName ?: "",
                    weatherStateAbbr = tomorrowWeather.weatherStateAbbr ?: "",
                    windDirectionCompass = tomorrowWeather.windDirectionCompass ?: "",
                    created = tomorrowWeather.created?.let { dateString ->
                        DateConvertorUtils.convertStringToCalendar(dateString, formatZIndex)
                    },
                    applicableDate = tomorrowWeather.applicableDate?.let { dateString ->
                        DateConvertorUtils.convertStringToCalendar(dateString, formatJustDate)
                    },
                    minTemp = tomorrowWeather.minTemp ?: 0.0,
                    maxTemp = tomorrowWeather.maxTemp ?: 0.0,
                    theTemp = tomorrowWeather.theTemp ?: 0.0,
                    windSpeed = tomorrowWeather.windSpeed ?: 0.0,
                    windDirection = tomorrowWeather.windDirection ?: 0.0,
                    airPressure = tomorrowWeather.airPressure ?: 0.0,
                    humidity = tomorrowWeather.humidity ?: 0,
                    visibility = tomorrowWeather.visibility ?: 0.0,
                    predictability = tomorrowWeather.predictability ?: 0
                )
            } ?: kotlin.run {
                null
            }

        }
    }


}