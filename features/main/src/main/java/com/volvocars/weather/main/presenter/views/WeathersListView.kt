package com.volvocars.weather.main.presenter.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.volvocars.weather.main.R
import com.volvocars.weather.main.presenter.views.card.WeatherCardModel
import com.volvocars.weather.main.presenter.views.card.WeatherCardState
import com.volvocars.weather.main.presenter.views.card.WeatherCardView

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WeathersListView(weathersItems: List<WeatherCardModel>) {

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text(stringResource(R.string.top_appbar_title_main_page)) }
            )
        }
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(weathersItems) { _, item ->
                WeatherCardView(item)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    WeathersListView(listOf(
        WeatherCardModel("Berlin", 1001, WeatherCardState.Loading, null),
        WeatherCardModel("London", 1001, WeatherCardState.Loading, null),
        WeatherCardModel("Berlin", 1001, WeatherCardState.Loading, null),
        WeatherCardModel("London", 1001, WeatherCardState.Loading, null)
    ))
}