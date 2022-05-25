package com.volvocars.weather.application

sealed class WeatherScreens(val route: String) {
    object MainScreen : WeatherScreens("home_screen")
}