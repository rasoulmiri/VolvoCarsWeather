package com.volvocars.weather.dependencies.groups.compose

class Compose {

    private object Versions {
        const val compose = "1.1.1"
        const val composeActivity = "1.4.0"
    }

    object Dependencies {
        const val ui =
            "androidx.compose.ui:ui:${Versions.compose}"
        const val material =
            "androidx.compose.material:material:${Versions.compose}"
        const val preview =
            "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val runtime =
            "androidx.compose.runtime:runtime:${Versions.compose}"
        const val activity =
            "androidx.activity:activity-compose:${Versions.composeActivity}"

        const val tooling =
            "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val manifest =
            "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    }

    val all = arrayOf(
        Dependencies.ui,
        Dependencies.material,
        Dependencies.preview,
        Dependencies.runtime,
        Dependencies.activity)

    val debugImplementation = arrayOf(
        Dependencies.tooling,
        Dependencies.manifest
    )

    fun getComposeVersion(): String {
        return Versions.compose
    }
}