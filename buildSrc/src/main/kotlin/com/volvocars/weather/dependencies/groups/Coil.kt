package com.volvocars.weather.dependencies.groups

class Coil {

    private object Versions {
        const val coil = "1.4.0"
    }

    private object Dependencies {
        const val coil =
            "io.coil-kt:coil-compose:${com.volvocars.weather.dependencies.groups.Coil.Versions.coil}"
    }

    fun getCoil(): String {
        return Dependencies.coil
    }

}