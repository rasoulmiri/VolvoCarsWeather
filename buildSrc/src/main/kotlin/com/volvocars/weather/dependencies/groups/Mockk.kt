package com.volvocars.weather.dependencies.groups

class Mockk {

    private object Versions {
        const val mockk = "1.10.2"
    }

    private object Dependencies {
        const val mockk =
            "io.mockk:mockk:${com.volvocars.weather.dependencies.groups.Mockk.Versions.mockk}"
    }

    val all = arrayOf(Dependencies.mockk)

}