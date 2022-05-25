package com.volvocars.weather.dependencies.groups

class Espresso {

    private object Versions {
        const val core = "3.1.0"
    }

    private object Dependencies {
        const val core =
            "androidx.test.espresso:espresso-core:${com.volvocars.weather.dependencies.groups.Espresso.Versions.core}"
    }

    val all = arrayOf(Dependencies.core)

}