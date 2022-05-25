package com.volvocars.weather.main.domain.usecase

import com.volvocars.weather.base.usecase.AsyncSuspendUseCase
import com.volvocars.weather.main.domain.model.ConsolidatedWeatherModel
import com.volvocars.weather.repository.ResultModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TomorrowWeatherCitiesUseCase(
    private val tomorrowWeatherUseCase: TomorrowWeatherUseCase,
) : AsyncSuspendUseCase<TomorrowWeatherCitiesRequestModel, Flow<TomorrowWeatherCitiesResponseModel?>> {

    var retryForError = 0

    override suspend fun executeAsync(rq: TomorrowWeatherCitiesRequestModel): Flow<TomorrowWeatherCitiesResponseModel?> {
        return flow {
            rq.cities.forEach {
                emit(getTomorrowWeatherOfCityUseCase(it))
            }
        }
    }

    private suspend fun getTomorrowWeatherOfCityUseCase(
        city:CityModel
    ): TomorrowWeatherCitiesResponseModel? {
        return when (val result = tomorrowWeatherUseCase.executeAsync(city.woeid)) {
            is ResultModel.Success<*> -> {
                retryForError = 0
                TomorrowWeatherCitiesResponseModel(city, result.value as ConsolidatedWeatherModel)
            }
            is ResultModel.Error -> {
                if (retryForError < 3) {
                    retryForError += 1
                    getTomorrowWeatherOfCityUseCase(city = city)
                } else {
                    null
                }
            }
        }
    }


}

data class TomorrowWeatherCitiesRequestModel(
    val cities: ArrayList<CityModel>,
)

data class TomorrowWeatherCitiesResponseModel(
    val city: CityModel,
    val weather: ConsolidatedWeatherModel?
)

data class CityModel(
    val index: Int,
    val name: String,
    val woeid: Long,
)