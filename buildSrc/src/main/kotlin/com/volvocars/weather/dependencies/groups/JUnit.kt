package com.volvocars.weather.dependencies.groups

class JUnit {

    private object Versions {
        const val junit = "4.12"
    }

    private object Dependencies {
        const val junit4 =
            "junit:junit:${Versions.junit}"
    }

    val all = arrayOf(Dependencies.junit4)

}