package com.volvocars.weather.dependencies.groups

class Koin {

    private object Versions {
        const val koin: String = "3.2.0"
    }

    private object Dependencies {
        const val koinAndroid: String =
            "io.insert-koin:koin-android:${Versions.koin}"
        const val koinCore: String =
            "io.insert-koin:koin-core:${Versions.koin}"
        const val koinAndroidxNavigation: String =
            "io.insert-koin:koin-androidx-navigation:${Versions.koin}"
        const val koinAndroidxCompose: String =
            "io.insert-koin:koin-androidx-compose:${Versions.koin}"
    }

    val all = arrayOf(
        Dependencies.koinAndroid,
        Dependencies.koinCore,
        Dependencies.koinAndroidxNavigation,
        Dependencies.koinAndroidxCompose)

}