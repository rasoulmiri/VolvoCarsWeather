package com.volvocars.weather.main.domain.model

import java.util.*

data class ConsolidatedWeatherModel(
    val id: Long,
    val weatherStateName: String,
    val weatherStateAbbr: String,
    val windDirectionCompass: String,
    val created: Calendar?,
    val applicableDate: Calendar?,
    val minTemp: Double,
    val maxTemp: Double,
    val theTemp: Double,
    val windSpeed: Double,
    val windDirection: Double,
    val airPressure: Double,
    val humidity: Long,
    val visibility: Double,
    val predictability: Long,
)