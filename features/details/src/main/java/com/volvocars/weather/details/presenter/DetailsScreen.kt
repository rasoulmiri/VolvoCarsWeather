package com.volvocars.weather.details.presenter

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.volvocars.weather.details.presenter.navigation.DetailsNavigationModel
import com.volvocars.weather.details.presenter.views.DetailsView

@Composable
fun DetailsScreen(navController: NavController, navigationModel: DetailsNavigationModel?) {
    Scaffold {
        DetailsView(navigationModel)
    }
}

