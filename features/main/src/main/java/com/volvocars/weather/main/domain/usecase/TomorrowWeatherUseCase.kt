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
) : AsyncSuspendUseCase<Long?, ResultModel<ConsolidatedWeatherModel?>> {

    override suspend fun executeAsync(rq: Long?): ResultModel<ConsolidatedWeatherModel?> {
        return repository.getWeatherCity(rq?:0).map {

            val tomorrowWeather = it.consolidatedWeather?.getOrNull(0)

            tomorrowWeather?.let {
                ConsolidatedWeatherModel(
                    id = tomorrowWeather.id ,
                    weatherStateName = tomorrowWeather.weatherStateName ,
                    weatherStateAbbr = tomorrowWeather.weatherStateAbbr ,
                    windDirectionCompass = tomorrowWeather.windDirectionCompass ,
                    created = tomorrowWeather.created?.let { dateString ->
                        DateConvertorUtils.convertStringToCalendar(dateString, formatZIndex)
                    },
                    applicableDate = tomorrowWeather.applicableDate?.let { dateString ->
                        DateConvertorUtils.convertStringToCalendar(dateString, formatJustDate)
                    },
                    minTemp = tomorrowWeather.minTemp ,
                    maxTemp = tomorrowWeather.maxTemp ,
                    theTemp = tomorrowWeather.theTemp ,
                    windSpeed = tomorrowWeather.windSpeed ,
                    windDirection = tomorrowWeather.windDirection ,
                    airPressure = tomorrowWeather.airPressure ,
                    humidity = tomorrowWeather.humidity ,
                    visibility = tomorrowWeather.visibility ,
                    predictability = tomorrowWeather.predictability 
                )
            } ?: kotlin.run {
                null
            }

        }
    }


}