package com.volvocars.weather.dependencies.groups.androidx

class AndroidXLifecycle {

    private object Versions {
        const val viewModel = "2.4.1"
        const val livedata = "2.4.1"
    }

    private object Dependencies {
        const val viewModel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${com.volvocars.weather.dependencies.groups.androidx.AndroidXLifecycle.Versions.viewModel}"
        const val livedata =
            "androidx.lifecycle:lifecycle-livedata-ktx:${com.volvocars.weather.dependencies.groups.androidx.AndroidXLifecycle.Versions.livedata}"
    }

    val all = arrayOf(
        Dependencies.viewModel,
        Dependencies.livedata
    )

}