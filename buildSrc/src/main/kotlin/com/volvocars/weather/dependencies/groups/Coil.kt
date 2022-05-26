package com.volvocars.weather.dependencies.groups

class Coil {

    private object Versions {
        const val coil = "2.1.0"
    }
    private object Dependencies {
        const val coil =
            "io.coil-kt:coil-compose:${Versions.coil}"
    }

    fun getCoil(): String {
        return Dependencies.coil
    }

}