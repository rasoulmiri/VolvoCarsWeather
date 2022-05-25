package com.volvocars.weather.dependencies.groups.androidx

class AndroidXNavigation {

    private object Versions {
        const val runtimeVersion = "2.4.0-alpha05"
        const val fragmentVersion = "2.4.0-alpha05"
        const val uiVersion = "2.4.0-alpha05"
    }

    private object Dependencies {
        const val runtime =
            "androidx.navigation:navigation-runtime-ktx:${Versions.runtimeVersion}"
        const val fragment =
            "androidx.navigation:navigation-fragment-ktx:${Versions.fragmentVersion}"
        const val ui =
            "androidx.navigation:navigation-ui-ktx:${Versions.uiVersion}"
    }

    val all = arrayOf(
        Dependencies.runtime,
        Dependencies.fragment,
        Dependencies.ui
    )

}