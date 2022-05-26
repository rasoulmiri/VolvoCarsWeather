package com.volvocars.weather.details.presenter.views

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.volvocars.weather.details.presenter.navigation.DetailsNavigationModel

@Composable
fun DetailsView(navigationModel: DetailsNavigationModel?) {

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text(navigationModel?.cityName ?: "NON") }
            )
        }
    ) {
        Text(text = "dddd")
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    DetailsView(null)
}