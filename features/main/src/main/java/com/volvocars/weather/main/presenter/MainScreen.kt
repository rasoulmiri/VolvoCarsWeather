package com.volvocars.weather.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.volvocars.weather.main.presenter.MainViewModel

import org.koin.java.KoinJavaComponent.inject

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(navController: NavController) {

    val viewModel by inject<MainViewModel>(MainViewModel::class.java)

    Scaffold {
        viewModel.getWeathers()
        ClickableText("Button") {}
    }
}

@Composable
fun ClickableText(name: String, onclick: () -> Unit) {
    Text(
        modifier = Modifier.clickable {
            onclick.invoke()
        },
        text = name
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ClickableText("Android") { }
}
