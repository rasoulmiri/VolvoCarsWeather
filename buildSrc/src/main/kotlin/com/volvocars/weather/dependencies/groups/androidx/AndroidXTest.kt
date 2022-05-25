package com.volvocars.weather.dependencies.groups.androidx

class AndroidXTest {

    private object Versions {
        const val test = "1.3.0"
        const val archCore = "2.1.0"
    }

    private object Dependencies {
        const val core =
            "androidx.test:core:${Versions.test}"
        const val rules =
            "androidx.test:rules:${Versions.test}"
        const val runner =
            "androidx.test:runner:${Versions.test}"
        const val archCore =
            "androidx.arch.core:core-testing:${com.volvocars.weather.dependencies.groups.androidx.AndroidXTest.Versions.archCore}"
    }

    val all = arrayOf(
        Dependencies.core,
        Dependencies.rules,
        Dependencies.runner,
        Dependencies.archCore
    )

}