package com.volvocars.weather.navigation.destinations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

object DetailsDestination : NavigationDestination {

    object Params {
        const val CITY_NAME = "city_name"
        const val TEMPERATURE = "temperature"
        const val TEMPERATURE_MIN = "temperature_min"
        const val TEMPERATURE_MAX = "temperature_max"
    }

    private const val DETAILS_ROUTE = "details"
    private const val DETAILS_ROUTE_WITH_KEY =
        "$DETAILS_ROUTE/{${Params.CITY_NAME}}/{${Params.TEMPERATURE}}/{${Params.TEMPERATURE_MIN}}/{${Params.TEMPERATURE_MAX}}"

    override val route = DETAILS_ROUTE_WITH_KEY
    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(Params.CITY_NAME) { type = NavType.StringType },
            navArgument(Params.TEMPERATURE) { type = NavType.StringType },
            navArgument(Params.TEMPERATURE_MIN) { type = NavType.StringType },
            navArgument(Params.TEMPERATURE_MAX) { type = NavType.StringType }
        )

    fun createDetailsRoute(
        cityName: String,
        temperature: String,
        temperatureMin: String,
        temperatureMax: String,
    ) = DETAILS_ROUTE +
            "/${cityName}" +
            "/${temperature}" +
            "/${temperatureMin}" +
            "/${temperatureMax}"

}
