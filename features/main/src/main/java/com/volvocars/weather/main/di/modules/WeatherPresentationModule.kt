package com.volvocars.weather.main.di.modules

import com.volvocars.weather.main.presenter.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherPresentationModule = module {
    viewModel { MainViewModel(get()) }
}