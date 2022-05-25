package com.volvocars.weather.main.presenter

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.volvocars.weather.main.presenter.views.WeathersListView
import org.koin.java.KoinJavaComponent.inject

@Composable
fun MainScreen(navController: NavController) {

    val viewModel by inject<MainViewModel>(MainViewModel::class.java)
    val items by viewModel.items.collectAsState()

    Scaffold {
        viewModel.getWeathers()
        WeathersListView(items)
    }
}

