package com.volvocars.weather.main.presenter

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.volvocars.weather.main.R
import com.volvocars.weather.main.domain.model.ConsolidatedWeatherModel
import com.volvocars.weather.main.presenter.views.WeatherCard
import org.koin.java.KoinJavaComponent.inject

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(navController: NavController) {

    val viewModel by inject<MainViewModel>(MainViewModel::class.java)
    val items by viewModel.items.collectAsState()

    Scaffold {
        viewModel.getWeathers()
        mainView(items)
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun mainView(items: List<WeatherCardModel>) {

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
            itemsIndexed(items) { index, item ->
                WeatherCard(item)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    mainView("Android") { }
}
