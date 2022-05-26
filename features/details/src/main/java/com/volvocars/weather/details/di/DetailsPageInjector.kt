package com.volvocars.weather.details.di

import com.volvocars.weather.details.di.modules.detailsPresentationModule

object DetailsPageInjector {
    fun provideDependencies() = listOf(
        detailsPresentationModule
    )
}