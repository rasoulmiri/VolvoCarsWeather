package com.volvocars.weather.main.domain.usecase

import com.volvocars.weather.base.usecase.AsyncSuspendUseCase
import com.volvocars.weather.base.utils.date.DateConvertorUtils
import com.volvocars.weather.base.utils.date.DateFormat.Companion.formatJustDate
import com.volvocars.weather.base.utils.date.DateFormat.Companion.formatZIndex
import com.volvocars.weather.main.data.entity.ConsolidatedWeatherEntity
import com.volvocars.weather.main.domain.WeatherRepository
import com.volvocars.weather.main.domain.mapper.mapToModel
import com.volvocars.weather.main.domain.model.ConsolidatedWeatherModel
import com.volvocars.weather.repository.ResultModel
import com.volvocars.weather.repository.map
import java.util.*

class TomorrowWeatherUseCase(
    private val repository: WeatherRepository,
) : AsyncSuspendUseCase<Long?, ResultModel<ConsolidatedWeatherModel?>> {

    override suspend fun executeAsync(rq: Long?): ResultModel<ConsolidatedWeatherModel?> {
        return repository.getWeatherCity(rq ?: 0).map {

            val tomorrowWeather = getTomorrowWeather(Calendar.getInstance(), it.consolidatedWeather)

            tomorrowWeather?.let {
                it.mapToModel()
            } ?: kotlin.run {
                null
            }

        }
    }

    fun getTomorrowWeather(
        today: Calendar,
        daysWeather: List<ConsolidatedWeatherEntity>?,
    ): ConsolidatedWeatherEntity? {
        return if (daysWeather?.isNotEmpty() == true) {

            var tomorrowWeather: ConsolidatedWeatherEntity? = null
            val tomorrow = with(today) {
                this.add(Calendar.DATE, 1)
                this
            }

            daysWeather.forEach {weather ->

                val day = weather.applicableDate?.let { dateString ->
                    DateConvertorUtils.convertStringToCalendar(dateString, formatJustDate)
                }?: return@forEach

                if (tomorrow.get(Calendar.YEAR) == day.get(Calendar.YEAR) &&
                    tomorrow.get(Calendar.DATE) == day.get(Calendar.DATE) &&
                    tomorrow.get(Calendar.DAY_OF_MONTH) == day.get(Calendar.DAY_OF_MONTH)
                ) {
                    tomorrowWeather = weather
                    return@forEach
                }
            }
            tomorrowWeather
        } else {
            null
        }

    }

}