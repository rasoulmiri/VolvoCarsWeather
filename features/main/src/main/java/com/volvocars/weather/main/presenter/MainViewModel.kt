package com.volvocars.weather.main.presenter

import com.volvocars.weather.main.domain.usecase.CityModel
import com.volvocars.weather.main.domain.usecase.TomorrowWeatherCitiesRequestModel
import com.volvocars.weather.main.domain.usecase.TomorrowWeatherCitiesUseCase
import com.volvocars.weather.main.presenter.views.card.WeatherCardModel
import com.volvocars.weather.main.presenter.views.card.WeatherCardState
import com.volvocars.weather.uikit.base.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.*

class MainViewModel(
    private val tomorrowWeatherCitiesUseCase: TomorrowWeatherCitiesUseCase,
) : BaseViewModel() {

    // TODO we need to change this after website was ready
    private val _items = MutableStateFlow<List<WeatherCardModel>>(arrayListOf(
        WeatherCardModel("Gothenburg", 100L, WeatherCardState.Loading, null),
        WeatherCardModel("Stockholm", 101L, WeatherCardState.Loading, null),
        WeatherCardModel("Mountain View", 102L, WeatherCardState.Loading, null),
        WeatherCardModel("London", 103L, WeatherCardState.Loading, null),
        WeatherCardModel("New York", 104L, WeatherCardState.Loading, null),
        WeatherCardModel("Berlin", 105L, WeatherCardState.Loading, null))
    )
    val items: StateFlow<List<WeatherCardModel>> = _items.asStateFlow()

    fun getWeathers() {

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
                            }
                        }
                        weatherCardModel
                    }
                }
        }

    }

}