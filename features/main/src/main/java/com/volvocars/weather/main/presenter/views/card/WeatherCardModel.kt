package com.volvocars.weather.main.presenter.views.card

import com.volvocars.weather.main.domain.model.ConsolidatedWeatherModel

data class WeatherCardModel(
    val name: String,
    val woeid: Long,
    var state: WeatherCardState,
    var image: String? = null,
    var data: ConsolidatedWeatherModel? = null,
)

enum class WeatherCardState {
    Loading, Success, Failed
}