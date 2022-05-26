package com.volvocars.weather.main.domain.mapper

import com.volvocars.weather.base.utils.date.DateConvertorUtils
import com.volvocars.weather.base.utils.date.DateFormat.Companion.formatJustDate
import com.volvocars.weather.base.utils.date.DateFormat.Companion.formatZIndex
import com.volvocars.weather.main.data.entity.ConsolidatedWeatherEntity
import com.volvocars.weather.main.domain.model.ConsolidatedWeatherModel

fun ConsolidatedWeatherEntity.mapToModel(): ConsolidatedWeatherModel {
        return ConsolidatedWeatherModel(
            id = this.id,
            weatherStateName = this.weatherStateName,
            weatherStateAbbr = this.weatherStateAbbr,
            windDirectionCompass = this.windDirectionCompass,
            created = this.created?.let { dateString ->
                DateConvertorUtils.convertStringToCalendar(dateString, formatZIndex)
            },
            applicableDate = this.applicableDate?.let { dateString ->
                DateConvertorUtils.convertStringToCalendar(dateString, formatJustDate)
            },
            minTemp = this.minTemp,
            maxTemp = this.maxTemp,
            theTemp = this.theTemp,
            windSpeed = this.windSpeed,
            windDirection = this.windDirection,
            airPressure = this.airPressure,
            humidity = this.humidity,
            visibility = this.visibility,
            predictability = this.predictability
        )
    }