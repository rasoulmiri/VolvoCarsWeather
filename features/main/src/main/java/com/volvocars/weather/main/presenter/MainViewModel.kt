package com.volvocars.weather.main.presenter

import androidx.lifecycle.viewModelScope
import com.volvocars.weather.main.domain.model.ConsolidatedWeatherModel
import com.volvocars.weather.main.domain.usecase.CityModel
import com.volvocars.weather.main.domain.usecase.TomorrowWeatherCitiesRequestModel
import com.volvocars.weather.main.domain.usecase.TomorrowWeatherCitiesUseCase
import com.volvocars.weather.uikit.base.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    private val tomorrowWeatherCitiesUseCase: TomorrowWeatherCitiesUseCase,
) : BaseViewModel() {

    private val _items = MutableStateFlow<List<WeatherCardModel>>(emptyList())
    val items: StateFlow<List<WeatherCardModel>> = _items.asStateFlow()

    private val cities: ArrayList<WeatherCardModel> = arrayListOf(
        WeatherCardModel("Gothenburg", 100L, WeatherCardState.Loading, null),
        WeatherCardModel("Stockholm", 101L, WeatherCardState.Loading, null),
        WeatherCardModel("Mountain View", 102L, WeatherCardState.Loading, null),
        WeatherCardModel("London", 103L, WeatherCardState.Loading, null),
        WeatherCardModel("New York", 104L, WeatherCardState.Loading, null),
        WeatherCardModel("Berlin", 105L, WeatherCardState.Loading, null),
    )

    init {
        viewModelScope.launch {
            _items.emit(cities)
            getWeathers()
        }
    }

    fun getWeathers() {

        track {
            val data: ArrayList<CityModel> = arrayListOf()
            cities.forEachIndexed { index, cityModel ->
                data.add(CityModel(index, cityModel.name, cityModel.woeid))
            }
            val tomorrowWeatherCitiesRequestModel = TomorrowWeatherCitiesRequestModel(data)

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

enum class WeatherCardState {
    Loading, Success, Failed
}

data class WeatherCardModel(
    val name: String,
    val woeid: Long,
    var state: WeatherCardState,
    var data: ConsolidatedWeatherModel? = null,
)