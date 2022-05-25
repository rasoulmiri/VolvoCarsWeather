package com.volvocars.weather.dependencies.groups

class Coroutines {

    private object Versions {
        const val coreVersion = "1.3.3"
        const val androidVersion = "1.3.0"
        const val testCoroutines = "1.4.2"
    }

    private object Dependencies {
        const val core =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coreVersion}"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.androidVersion}"

        const val testCoroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${com.volvocars.weather.dependencies.groups.Coroutines.Versions.testCoroutines}"
    }

    val all = arrayOf(
        Dependencies.core,
        Dependencies.android)

    val test =
        arrayOf(Dependencies.testCoroutines)

}