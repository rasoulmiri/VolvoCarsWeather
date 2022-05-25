package com.volvocars.weather.main.domain.model

import java.util.*

data class ConsolidatedWeatherModel(
    val id: Long?,
    val weatherStateName: String?,
    val weatherStateAbbr: String?,
    val windDirectionCompass: String?,
    val created: Calendar?,
    val applicableDate: Calendar?,
    val minTemp: String?,
    val maxTemp: String?,
    val theTemp: String?,
    val windSpeed: String?,
    val windDirection: String?,
    val airPressure: String?,
    val humidity: Long?,
    val visibility: String?,
    val predictability: String?,
)