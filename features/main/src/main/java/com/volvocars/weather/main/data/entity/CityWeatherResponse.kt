package com.volvocars.weather.main.data.entity

import androidx.annotation.Keep

@Keep
data class CityWeatherResponse (
    val consolidatedWeather: List<ConsolidatedWeatherEntity>? = null,
    val time: String? = null,
    val sunRise: String? = null,
    val sunSet: String? = null,
    val timezoneName: String? = null,
    val parent: ParentEntity? = null,
    val sources: List<SourceEntity>? = null,
    val title: String? = null,
    val locationType: String? = null,
    val woeid: Long? = null,
    val lattLong: String? = null,
    val timezone: String? = null
)

@Keep
data class ConsolidatedWeatherEntity (
    val id: Long? = null,
    val weatherStateName: String? = null,
    val weatherStateAbbr: String? = null,
    val windDirectionCompass: String? = null,
    val created: String? = null,
    val applicableDate: String? = null,
    val minTemp: Double? = null,
    val maxTemp: Double? = null,
    val theTemp: Double? = null,
    val windSpeed: Double? = null,
    val windDirection: Double? = null,
    val airPressure: Double? = null,
    val humidity: Long? = null,
    val visibility: Double? = null,
    val predictability: Long? = null
)

@Keep
data class ParentEntity (
    val title: String? = null,
    val locationType: String? = null,
    val woeid: Long? = null,
    val lattLong: String? = null
)

@Keep
data class SourceEntity (
    val title: String? = null,
    val slug: String? = null,
    val url: String? = null,
    val crawlRate: Long? = null
)
