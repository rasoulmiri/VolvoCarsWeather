package com.volvocars.weather.main.data.entity

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CityWeatherResponseEntity (
    @SerializedName("consolidated_weather")
    val consolidatedWeather: List<ConsolidatedWeatherEntity>? = null,
    val time: String? = null,
    @SerializedName("sun_rise")
    val sunRise: String? = null,
    @SerializedName("sun_set")
    val sunSet: String? = null,
    @SerializedName("timezone_name")
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
    @SerializedName("weather_state_name")
    val weatherStateName: String? = null,
    @SerializedName("weather_state_abbr")
    val weatherStateAbbr: String? = null,
    @SerializedName("wind_direction_compass")
    val windDirectionCompass: String? = null,
    val created: String? = null,
    @SerializedName("applicable_date")
    val applicableDate: String? = null,
    @SerializedName("min_temp")
    val minTemp: Double? = null,
    @SerializedName("max_temp")
    val maxTemp: Double? = null,
    @SerializedName("the_temp")
    val theTemp: Double? = null,
    @SerializedName("wind_speed")
    val windSpeed: Double? = null,
    @SerializedName("wind_direction")
    val windDirection: Double? = null,
    @SerializedName("air_pressure")
    val airPressure: Double? = null,
    val humidity: Long? = null,
    val visibility: Double? = null,
    val predictability: Long? = null
)

@Keep
data class ParentEntity (
    val title: String? = null,
    @SerializedName("location_type")
    val locationType: String? = null,
    val woeid: Long? = null,
    @SerializedName("latt_long")
    val lattLong: String? = null
)

@Keep
data class SourceEntity (
    val title: String? = null,
    val slug: String? = null,
    val url: String? = null,
    @SerializedName("crawl_rate")
    val crawlRate: Long? = null
)
