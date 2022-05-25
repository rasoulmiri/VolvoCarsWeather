package com.volvocars.weather.application

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.volvocars.weather.main.presenter.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WeatherScreens.MainScreen.route) {
        composable(route = WeatherScreens.MainScreen.route) {
            MainScreen(navController = navController)
        }
    }
}