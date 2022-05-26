package com.volvocars.weather.main.presenter

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.volvocars.weather.main.presenter.views.WeathersListView

@Composable
fun MainScreen(navController: NavController,viewModel:MainViewModel) {

    val items by viewModel.items.collectAsState()

    Scaffold {
        WeathersListView(items, navController)
    }
}

