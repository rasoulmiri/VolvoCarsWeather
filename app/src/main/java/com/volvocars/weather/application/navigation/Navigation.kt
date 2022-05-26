package com.volvocars.weather.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.volvocars.weather.details.presenter.DetailsScreen
import com.volvocars.weather.details.presenter.navigation.DetailsNavigationModel
import com.volvocars.weather.main.presenter.MainScreen
import com.volvocars.weather.navigation.destinations.DetailsDestination
import com.volvocars.weather.navigation.destinations.MainDestination

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainDestination.route) {
        composable(route = MainDestination.route, MainDestination.arguments) {
            MainScreen(navController = navController)
        }
        composable(route = DetailsDestination.route,
            arguments = DetailsDestination.arguments) { entry ->
            DetailsScreen(navController,
                DetailsNavigationModel(
                    cityName = entry.arguments?.getString(DetailsDestination.Params.CITY_NAME),
                    temperature = entry.arguments?.getString(DetailsDestination.Params.TEMPERATURE),
                    temperatureMin = entry.arguments?.getString(DetailsDestination.Params.TEMPERATURE_MIN),
                    temperatureMax = entry.arguments?.getString(DetailsDestination.Params.TEMPERATURE_MAX)
                )
            )
        }

    }
}