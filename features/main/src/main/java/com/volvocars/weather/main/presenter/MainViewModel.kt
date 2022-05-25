package com.volvocars.weather.main.presenter

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.volvocars.weather.main.domain.model.ConsolidatedWeatherModel
import com.volvocars.weather.main.domain.usecase.CityModel
import com.volvocars.weather.main.domain.usecase.TomorrowWeatherCitiesRequestModel
import com.volvocars.weather.main.domain.usecase.TomorrowWeatherCitiesUseCase
import com.volvocars.weather.uikit.base.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.collect

class MainViewModel(
    private val tomorrowWeatherCitiesUseCase: TomorrowWeatherCitiesUseCase,
) : BaseViewModel() {

    private val _items = mutableStateOf<List<ConsolidatedWeatherModel>>(emptyList())
    val items: State<List<ConsolidatedWeatherModel>> = _items

     fun getWeathers() {

        track {
            val cities: ArrayList<CityModel> = arrayListOf(
                CityModel(0,"Gothenburg",100L),
                CityModel(0,"Stockholm",100L),
                CityModel(0,"Mountain View",100L),
                CityModel(0,"London",100L),
                CityModel(0,"New York",100L),
                CityModel(0,"Berlin",100L),
            )
            val tomorrowWeatherCitiesRequestModel=TomorrowWeatherCitiesRequestModel(cities)

            tomorrowWeatherCitiesUseCase.executeAsync(tomorrowWeatherCitiesRequestModel).collect {
//                _items.value = listOf(it) as List<RandomComicsResponseModel>
                Log.i("--->",it.toString())
            }
        }

    }

}