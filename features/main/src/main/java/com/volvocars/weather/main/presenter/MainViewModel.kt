package com.volvocars.weather.main.presenter

import androidx.lifecycle.viewModelScope
import com.volvocars.weather.main.domain.usecase.CityModel
import com.volvocars.weather.main.domain.usecase.TomorrowWeatherCitiesRequestModel
import com.volvocars.weather.main.domain.usecase.TomorrowWeatherCitiesUseCase
import com.volvocars.weather.main.presenter.views.card.WeatherCardModel
import com.volvocars.weather.main.presenter.views.card.WeatherCardState
import com.volvocars.weather.uikit.base.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch

class MainViewModel(
    private val tomorrowWeatherCitiesUseCase: TomorrowWeatherCitiesUseCase,
) : BaseViewModel() {

    // TODO we need to change this after website was ready
    private val _items = MutableStateFlow<List<WeatherCardModel>>(arrayListOf())
    val items: StateFlow<List<WeatherCardModel>> = _items.asStateFlow()

    init {
        viewModelScope.launch {
            _items.emit(arrayListOf(
                WeatherCardModel("Gothenburg", 100L, WeatherCardState.Loading),
                WeatherCardModel("Stockholm", 101L, WeatherCardState.Loading),
                WeatherCardModel("Mountain View", 102L, WeatherCardState.Loading),
                WeatherCardModel("London", 103L, WeatherCardState.Loading),
                WeatherCardModel("New York", 104L, WeatherCardState.Loading),
                WeatherCardModel("Berlin", 105L, WeatherCardState.Loading)))
            getWeathers()
        }
    }

    fun getWeathers() {

        removeAllJob()

        track {

            val cities: ArrayList<CityModel> = arrayListOf<CityModel>().apply {
                _items.value.forEachIndexed { index, cityModel ->
                    add(CityModel(index, cityModel.name, cityModel.woeid))
                }
            }
            val tomorrowWeatherCitiesRequestModel = TomorrowWeatherCitiesRequestModel(cities)

            tomorrowWeatherCitiesUseCase.executeAsync(tomorrowWeatherCitiesRequestModel)
                .collect { response ->
                    _items.getAndUpdate { weatherCardModel ->
                        weatherCardModel.forEach { item ->
                            if (item.woeid == response?.city?.woeid) {
                                item.data = response.weather
                                item.state = WeatherCardState.Success
                                item.image =
                                    if (item.data?.weatherStateAbbr?.isNotEmpty() == true) {
                                        "https://www.metaweather.com/static/img/weather/png/64/${item.data?.weatherStateAbbr}.png"
                                    } else {
                                        null
                                    }
                            }
                        }
                        weatherCardModel
                    }
                }
        }

    }

}